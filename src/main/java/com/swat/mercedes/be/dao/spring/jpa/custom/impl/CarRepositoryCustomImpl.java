package com.swat.mercedes.be.dao.spring.jpa.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.swat.mercedes.be.dao.spring.jpa.custom.CarRepositoryCustomInterface;
import com.swat.mercedes.be.entities.Car;

public class CarRepositoryCustomImpl implements CarRepositoryCustomInterface {

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List<Car> findCarsInServiceForMoreThenOneMonth() {
	return entityManager.createQuery("from Car car where....", Car.class).getResultList();
    }

}
