package com.swat.mercedes.be.dao.spring.jpa.custom;

import java.util.List;

import com.swat.mercedes.be.entities.Car;

/**
 * 
 * @author eugen
 * Suppose we need a method that gets all cars that are in service for more then a month.
 * Implementing Spring Data JPA this becomes a bit cumbersome to do with @NamedQuery, so this is how it's done.
 * First provide the interface that shows the methos.
 *
 */

public interface CarRepositoryCustomInterface {
    List<Car> findCarsInServiceForMoreThenOneMonth();
    List<Car> findCarsWithMoreThen100kkm();
}
