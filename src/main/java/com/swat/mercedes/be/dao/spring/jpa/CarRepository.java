package com.swat.mercedes.be.dao.spring.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swat.mercedes.be.dao.spring.jpa.custom.CarRepositoryCustomInterface;
import com.swat.mercedes.be.entities.Car;

/**
 * 
 * @author eugen
 * Some things need to be explained : 
 * 
 * 1. We only need to define a repository interface and the implementation will be provided automatically.
 * 	For Spring to be able to auto-wire the bean, wee need to set this property in application context:
 * 	<jpa:repositories base-package="com.swat.mercedes.be.dao.spring.jpa.custom.impl" />
 * 
 *    Now whenever we wire the UserRepository, we will receive a fully functional repository implementation automatically.
 *    The repository will have full CRUD functionality, due to extending the CrudRepository interface, but also custom find behavior.
 * 
 * 2. Notice that we have also defined a findByCarname method - this is called dynamic finder methods and will be resolved automatically when the naming convention is respected.
 *    Look at this link for more details : http://static.springsource.org/spring-data/data-jpa/docs/1.0.0.M1/reference/html/
 * 
 * 
 * 3. We have extended from CarRepositoryCustomInterface, thus the findCarsInServiceForMoreThenOneMonth() method is going to be found.
 * 
 * 4. We have defined also a method called findByTheCarsName. Now this method is resolved in the Entity (Model class) eventually (see Car Entity @NamedQuery)
 *    Same thing can be achieved with the @Query annotation (see getAllOrders method)
 *   
 */
public interface CarRepository  extends JpaRepository<Car, Long>, CarRepositoryCustomInterface{
    Car findByCarName(Car name);
    Car findByTheCarsName(Car name);
    
    @Query("select ...... ")
    List<Car> getAllOrders();
    
}
