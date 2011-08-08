package com.swat.mercedes.be.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ForeignKey;
import org.springframework.core.style.ToStringCreator;

/**
 * Client entity class
 * 
 * @author Victor Stefoglo
 * 
 */
@Entity(name="T_CLIENT")
public class Client extends BaseEntity {

    private static final long serialVersionUID = 1932022457641182327L;

    @Column(name = "FIRST_NAME", nullable = false, length = 255)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 255)
    private String lastName;

    @Column(name = "PHONE", length = 50)
    private String phone;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "T_CLIENT_CAR", joinColumns = @JoinColumn(name = "FK_CLIENT_ID", nullable = false),
	    inverseJoinColumns = @JoinColumn(name = "FK_CAR_ID", nullable = false))
    @ForeignKey(name = "CLIENT_CAR_FK")
    private Set<Car> cars = new HashSet<Car>(0);

    /**
     * Default constructor.
     */
    public Client() {
	super();
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
	return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
	return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone) {
	this.phone = phone;
    }

    /**
     * @return the cars
     */
    public Set<Car> getCars() {
	return cars;
    }

    /**
     * @param cars
     *            the cars to set
     */
    public void setCars(Set<Car> cars) {
	this.cars = cars;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.entities.BaseEntity#toString()
     */
    @Override
    public String toString() {
	ToStringCreator stringCreator = new ToStringCreator(this);
	stringCreator.append(super.toString());
	stringCreator.append("firstName", firstName);
	stringCreator.append("lastName", lastName);
	stringCreator.append("phone", phone);
	stringCreator.append("cars", cars);
	return stringCreator.toString();
    }
}
