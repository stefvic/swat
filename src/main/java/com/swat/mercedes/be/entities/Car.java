package com.swat.mercedes.be.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;
import org.springframework.core.style.ToStringCreator;

/**
 * Car entity class
 * 
 * @author Victor Stefoglo
 * 
 */
@Entity(name = "T_CAR")
// Yet to be defined
@NamedQuery(
	name="Car.findByTheCarsName",
	query="from T_CAR car where car.vinCode = ? "
)
public class Car extends BaseEntity {

    private static final long serialVersionUID = -3538580041167148461L;

    @Column(name = "IDENTITY", nullable = false, length = 255)
    private String identity;

    @Column(name = "VIN_CODE", nullable = false, length = 255)
    private String vinCode;

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
     * @return the vinCode
     */
    public String getvinCode() {
	return vinCode;
    }

    /**
     * @param vinCode
     *            the vinCode to set
     */
    public void setvinCode(String vinCode) {
	this.vinCode = vinCode;
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

    /*
     * (non-Javadoc)
     * 
     * @see com.swat.mercedes.be.entities.BaseEntity#toString()
     */
    @Override
    public String toString() {
	ToStringCreator stringCreator = new ToStringCreator(this);
	stringCreator.append(super.toString());
	stringCreator.append("identity", identity);
	stringCreator.append("vinCode", vinCode);
	stringCreator.append("km", km);
	stringCreator.append("orders", orders);
	stringCreator.append("clients", clients);
	return stringCreator.toString();
    }
}
