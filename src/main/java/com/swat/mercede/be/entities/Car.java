package com.swat.mercede.be.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;

/**
 * Car entity class
 * 
 * @author Victor Stefoglo
 * 
 */
@Entity(name="T_CAR")
public class Car extends BaseEntity {

    private static final long serialVersionUID = -3538580041167148461L;

    @Column(name = "IDENTITY", nullable = false, length = 255)
    private String identity;

    @Column(name = "WIN_CODE", nullable = false, length = 255)
    private String winCode;

    @Column(name = "KM", scale = 18)
    private long km;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "car")
    private Set<Order> orders;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "cars")
    @ForeignKey(name = "CAR_CLIENT_FK")
    private Set<Client> clients = new HashSet<Client>(0);

    /**
     * Default constructor.
     */
    public Car() {
	super();
    }

    /**
     * @return the identity
     */
    public String getIdentity() {
	return identity;
    }

    /**
     * @param identity
     *            the identity to set
     */
    public void setIdentity(String identity) {
	this.identity = identity;
    }

    /**
     * @return the winCode
     */
    public String getWinCode() {
	return winCode;
    }

    /**
     * @param winCode
     *            the winCode to set
     */
    public void setWinCode(String winCode) {
	this.winCode = winCode;
    }

    /**
     * @return the km
     */
    public long getKm() {
	return km;
    }

    /**
     * @param km
     *            the km to set
     */
    public void setKm(long km) {
	this.km = km;
    }

    /**
     * @return the orders
     */
    public Set<Order> getOrders() {
	return orders;
    }

    /**
     * @param orders
     *            the orders to set
     */
    public void setOrders(Set<Order> orders) {
	this.orders = orders;
    }

    /**
     * @return the clients
     */
    public Set<Client> getClients() {
	return clients;
    }

    /**
     * @param clients
     *            the clients to set
     */
    public void setClients(Set<Client> clients) {
	this.clients = clients;
    }

}
