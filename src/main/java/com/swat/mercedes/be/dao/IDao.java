package com.swat.mercedes.be.dao;

import java.io.Serializable;
import java.util.List;

import com.swat.mercedes.be.dao.exception.DaoException;
import com.swat.mercedes.be.entities.IEntity;

/**
 * Interface of generic DAO.
 * 
 * @param <T>
 *            object's type, it must implements at least IEntity
 * @param <I>
 *            primary key's type, it must implements Serializable
 * 
 * @author Victor Stefoglo
 * 
 */
public interface IDao<T extends IEntity<I>, I extends Serializable> {
    /**
     * Retrieve an persisted object using the given id as primary key.
     * 
     * @param id
     *            object's primary key
     * @return object
     * @throws DaoException
     *             - if not found
     */
    T load(I id) throws DaoException;

    /**
     * Retrieve an persisted object using the given id as primary key.
     * 
     * Returns null if not found.
     * 
     * @param id
     *            object's primary key
     * @return object
     * @throws DaoException
     */
    T get(I id) throws DaoException;

    /**
     * Retrieve an persisted objects using the given ids as primary keys.
     * 
     * @param ids
     *            objects's ids
     * @return list of objects
     * @throws DaoException
     */
    List<T> get(I... ids) throws DaoException;

    /**
     * Retrieve all persisted objects.
     * 
     * @return list of objects
     * @throws DaoException
     */
    List<T> getAll() throws DaoException;

    /**
     * Save all changes made to an object.
     * 
     * @param object
     *            object
     * @throws DaoException
     */
    void save(T object) throws DaoException;

    /**
     * Save all changes made to objects.
     * 
     * @param objects
     *            objects
     * @throws DaoException
     */
    void save(T... objects) throws DaoException;

    /**
     * Remove an object by given id.
     * 
     * @param id
     *            object's pk
     * @throws DaoException
     */
    void delete(I id) throws DaoException;

    /**
     * Remove objects by given ids.
     * 
     * @param ids
     *            objects's pk
     * @throws DaoException
     */
    void delete(I... ids) throws DaoException;

    /**
     * Remove an object.
     * 
     * @param object
     *            object
     * @throws DaoException
     */
    void delete(T object) throws DaoException;

    /**
     * Remove objects.
     * 
     * @param objects
     *            objects
     * @throws DaoException
     * @see IHiddenable
     */
    void delete(T... objects) throws DaoException;

    /**
     * Refresh a persistant object that may have changed in another
     * thread/transaction.
     * 
     * @param entity
     *            transient entity
     * @throws DaoException
     */
    void refresh(T entity) throws DaoException;

    /**
     * Write to database anything that is pending operation.
     * 
     * @throws DaoException
     */
    void flush() throws DaoException;

    /**
     * Clear cache
     */
    void clear() throws DaoException;

    /**
     * Write to database anything that is pending operation and clear it.
     * 
     * @throws DaoException
     */
    void flushAndClear() throws DaoException;

}
