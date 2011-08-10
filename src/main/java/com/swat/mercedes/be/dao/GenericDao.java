package com.swat.mercedes.be.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swat.mercedes.be.dao.exception.DaoException;
import com.swat.mercedes.be.entities.IEntity;

/**
 * Abstract implementation of generic DAO.
 * 
 * @param <T>
 *            entity type, it must implements at least IEntity
 * @param <I>
 *            entity's primary key, it must be serializable
 * @see IEntity
 * 
 * @author Victor Stefoglo
 * 
 * @deprecated Use {@link GenericRepository} spring implementation instead of this
 */
public abstract class GenericDao<T extends IEntity<I>, I extends Serializable> implements IDao<T, I> {

    private static final Logger logger = LoggerFactory.getLogger(GenericDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    private Class<IEntity<I>> entityClass;

    /**
     * Default constructor.
     */
    @SuppressWarnings("unchecked")
    public GenericDao() {
	Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();

	if (types[0] instanceof ParameterizedType) {
	    // If the class has parameterized types, it takes the raw type.
	    ParameterizedType type = (ParameterizedType) types[0];
	    entityClass = (Class<IEntity<I>>) type.getRawType();
	} else {
	    entityClass = (Class<IEntity<I>>) types[0];
	}
    }

    /**
     * Constructor with given {@link IEntity} implementation. Use for creating
     * DAO without extending this class.
     * 
     * @param clazz
     *            class with will be accessed by DAO methods
     */
    public GenericDao(Class<IEntity<I>> entityClass) {
	this.entityClass = entityClass;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.dao.IDao#load(java.io.Serializable)
     */
    @Override
    public T load(I id) throws DaoException {
	try {
	    logger.debug(">> Start load entity '{}' by id '{}'", entityClass, id);
	    T entity = get(id);
	    if (entity == null) {
		throw new DaoException("Entity: " + entityClass + "#" + id + " was not found");
	    }
	    logger.debug("Entity '{}#{}' loaded successfully", entityClass, id);
	    return entity;
	} catch (DaoException e) {
	    logger.error(e.getMessage());
	    throw e;
	} finally {
	    logger.debug("<< End load entity");
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.dao.IDao#get(java.io.Serializable)
     */
    @SuppressWarnings("unchecked")
    @Override
    public T get(I id) throws DaoException {
	try {
	    logger.debug(">> Start get entity '{}' by id '{}'", entityClass, id);
	    return (T) entityManager.find(entityClass, id);
	} catch (IllegalArgumentException iae) {
	    logger.error(iae.getMessage());
	    throw new DaoException(iae.getMessage(), iae.getCause());
	} finally {
	    logger.debug("<< End get entity");
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.dao.IDao#get(I[])
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> get(I... ids) {
	try {
	    logger.debug(">> Start get entities by id {}", ids);
	    CriteriaQuery<T> criteriaQuery = createRootEntityQuery();
	    Root<T> entityRoot = (Root<T>) criteriaQuery.from(entityClass);
	    Path<I> idPath = (Path<I>) entityRoot.get(entityRoot.getModel().getSingularAttribute(IEntity.ID));
	    criteriaQuery.where(entityManager.getCriteriaBuilder().in(idPath).in((Object[]) ids));
	    List<T> result = entityManager.createQuery(criteriaQuery).getResultList();
	    return result;
	} catch (IllegalArgumentException iae) {
	    logger.error(iae.getMessage());
	    throw new DaoException(iae.getMessage(), iae.getCause());
	} catch (PersistenceException pe) {
	    logger.error(pe.getMessage());
	    throw new DaoException(pe.getMessage(), pe.getCause());
	} finally {
	    logger.debug("<< End save entity.");
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.dao.IDao#getAll()
     */
    @Override
    public List<T> getAll() {
	CriteriaQuery<T> criteriaQuery = createRootEntityQuery();
	List<T> result = entityManager.createQuery(criteriaQuery).getResultList();
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.swat.mercedes.be.dao.IDao#save(com.swat.mercedes.be.entities.IEntity)
     */
    @Override
    public void save(final T object) throws DaoException {
	try {
	    logger.debug(">> Start save entity '{}'", entityClass);
	    if (object.getId() != null) {
		entityManager.merge(object);
	    } else {
		entityManager.persist(object);
	    }
	    logger.debug("Entity saved successfully.");
	} catch (IllegalArgumentException iae) {
	    logger.error(iae.getMessage());
	    throw new DaoException(iae.getMessage(), iae.getCause());
	} catch (PersistenceException pe) {
	    logger.error(pe.getMessage());
	    throw new DaoException(pe.getMessage(), pe.getCause());
	} finally {
	    logger.debug("<< End save entity.");
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.dao.IDao#save(T[])
     */
    @Override
    public void save(final T... objects) {
	try {
	    logger.debug(">> Start save entities.");
	    for (T object : objects) {
		save(object);
	    }
	    logger.debug("Entities saved successfully.");
	} catch (DaoException e) {
	    logger.error(e.getMessage());
	    throw e;
	} finally {
	    logger.debug("<< End save entities.");
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.dao.IDao#delete(java.io.Serializable)
     */
    @Override
    public void delete(I id) throws UnsupportedOperationException {
	delete(load(id));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.dao.IDao#delete(I[])
     */
    @Override
    public void delete(I... ids) throws UnsupportedOperationException {
	for (I id : ids) {
	    delete(id);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.swat.mercedes.be.dao.IDao#delete(com.swat.mercedes.be.entities.IEntity
     * )
     */
    @Override
    public void delete(T object) throws UnsupportedOperationException {
	entityManager.remove(object);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.dao.IDao#delete(T[])
     */
    @Override
    public void delete(T... objects) throws UnsupportedOperationException {
	for (T object : objects) {
	    entityManager.remove(object);
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.swat.mercedes.be.dao.IDao#refresh(com.swat.mercedes.be.entities.IEntity
     * )
     */
    @Override
    public void refresh(T entity) {
	entityManager.refresh(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.dao.IDao#flush()
     */
    @Override
    public void flush() {
	entityManager.flush();

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.dao.IDao#clear()
     */
    @Override
    public void clear() {
	entityManager.clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.dao.IDao#flushAndClear()
     */
    @Override
    public void flushAndClear() {
	flush();
	clear();
    }

    /**
     * Create criteria query for entity <T>
     * 
     * @return - CriteriaQuery<T>
     */
    @SuppressWarnings("unchecked")
    protected CriteriaQuery<T> createRootEntityQuery() {
	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(entityClass);
	Root<T> entityRoot = (Root<T>) criteriaQuery.from(entityClass);
	criteriaQuery.select(entityRoot);

	return criteriaQuery;
    }

}
