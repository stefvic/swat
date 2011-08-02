package com.swat.mercede.be.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

/**
 * Order entity class
 * 
 * @author Victor Stefoglo
 * 
 */
@Entity(name = "T_ORDER")
public class Order extends BaseEntity {

    private static final long serialVersionUID = -8501462321704419637L;

    /**
     * Default constructor.
     */
    public Order() {
	super();
    }

    @Column(name = "DESCRIPTION", length = 255, nullable = false)
    private String description;

    @Column(name = "COST", scale = 12, precision = 2)
    private double cost;

    @Column(name = "EXTRA_COST", scale = 12, precision = 2)
    private double extraCost;

    @Column(name = "COMPLETED", nullable = false)
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "FK_T_ITEM", nullable = false)
    @ForeignKey(name = "ORDER_FK_T_ITEM")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "FK_T_CAR", nullable = false)
    @ForeignKey(name = "ORDER_FK_T_CAR")
    private Car car;

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @return the cost
     */
    public double getCost() {
	return cost;
    }

    /**
     * @param cost
     *            the cost to set
     */
    public void setCost(double cost) {
	this.cost = cost;
    }

    /**
     * @return the extraCost
     */
    public double getExtraCost() {
	return extraCost;
    }

    /**
     * @param extraCost
     *            the extraCost to set
     */
    public void setExtraCost(double extraCost) {
	this.extraCost = extraCost;
    }

    /**
     * @return the completed
     */
    public boolean isCompleted() {
	return completed;
    }

    /**
     * @param completed
     *            the completed to set
     */
    public void setCompleted(boolean completed) {
	this.completed = completed;
    }

    /**
     * @return the item
     */
    public Item getItem() {
	return item;
    }

    /**
     * @param item
     *            the item to set
     */
    public void setItem(Item item) {
	this.item = item;
    }

    /**
     * @return the car
     */
    public Car getCar() {
	return car;
    }

    /**
     * @param car
     *            the car to set
     */
    public void setCar(Car car) {
	this.car = car;
    }

}
