package com.swat.mercedes.be.dao.spring.jpa.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.swat.mercedes.be.dao.spring.jpa.custom.CarRepositoryCustomInterface;
import com.swat.mercedes.be.entities.Car;

public class CarRepositoryCustomImpl implements CarRepositoryCustomInterface {

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<Car> findCarsInServiceForMoreThenOneMonth() {
	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	CriteriaQuery<Car> query = builder.createQuery(Car.class);
	Root<Car> root = query.from(Car.class);
	
	//Predicate vinCode = builder.equal(root.get();
	
	
	return entityManager.createQuery("from Car car where....", Car.class).getResultList();
    }

}
