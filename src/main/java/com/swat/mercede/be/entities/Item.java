package com.swat.mercede.be.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Item entity class
 * 
 * @author Victor Stefoglo
 * 
 */
@Entity(name = "T_ITEM")
public class Item extends BaseEntity {

    private static final long serialVersionUID = 1666885328660556609L;

    @Column(name = "CODE", length = 255, nullable = false)
    private String code;

    @Column(name = "NAME", length = 255, nullable = false)
    private String name;

    @Column(name = "PRICE", scale = 12, precision = 2)
    private double price;

    @Column(name = "SPRICE", scale = 12, precision = 2)
    private double sprice;

    @Column(name = "QUANTITY", scale = 18)
    private long quantity;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "item")
    private Set<Order> orders = new HashSet<Order>(0);

    /**
     * Default constructor.
     */
    public Item() {
	super();
    }

    /**
     * @return the code
     */
    public String getCode() {
	return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
	this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
	return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(double price) {
	this.price = price;
    }

    /**
     * @return the sprice
     */
    public double getSprice() {
	return sprice;
    }

    /**
     * @param sprice
     *            the sprice to set
     */
    public void setSprice(double sprice) {
	this.sprice = sprice;
    }

    /**
     * @return the quantity
     */
    public long getQuantity() {
	return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(long quantity) {
	this.quantity = quantity;
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

}
