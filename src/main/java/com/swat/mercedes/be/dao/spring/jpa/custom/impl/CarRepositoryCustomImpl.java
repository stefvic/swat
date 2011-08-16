package com.swat.mercedes.be.dao.spring.jpa.custom.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.swat.mercedes.be.dao.spring.jpa.custom.CarRepositoryCustomInterface;
import com.swat.mercedes.be.entities.Car;
import com.swat.mercedes.be.entities.QCar;

/**
 * Some more could be used
 * 
 * 
 */

public class CarRepositoryCustomImpl implements CarRepositoryCustomInterface {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Car> findCarsInServiceForMoreThenOneMonth() {
	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	CriteriaQuery<Car> query = builder.createQuery(Car.class);
	Root<Car> root = query.from(Car.class);

	// Predicate vinCode = builder.equal(root.get();

	return entityManager.createQuery("from Car car where....", Car.class).getResultList();
    }

    @Override
    public List<Car> findCarsWithMoreThen100kkm() {

	JPQLQuery query = new JPAQuery(entityManager);
	QCar car = QCar.car;
	ArrayList<Car> cars = (ArrayList<Car>) query.from(car).where(car.km.gt(100000)).list(car);
	return cars;
    }

}
