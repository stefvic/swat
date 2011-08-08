package com.swat.mercedes.be.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.core.style.ToStringCreator;

/**
 * Base entity class
 * 
 * @author Victor Stefoglo
 * 
 */
@MappedSuperclass
public abstract class BaseEntity implements IEntity<Long> {

    private static final long serialVersionUID = -2430838712355310686L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", scale = 18)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;

    /**
     * Default constructor.
     */
    public BaseEntity() {
	init();
    }

    /**
     * Initialize instance variables.
     * 
     */
    protected void init() {
	createdDate = new Date();
    }

    /**
     * @return the id
     */
    public Long getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
	return createdDate;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	ToStringCreator stringCreator = new ToStringCreator(this);
	stringCreator.append("id", id);
	stringCreator.append("createdDate", createdDate);
	return stringCreator.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	int hashCode = 0;
	if (id != null) {
	    hashCode += id;
	}
	return hashCode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	boolean equals = false;
	if (obj != null && obj instanceof BaseEntity) {
	    equals = id.equals(((BaseEntity) obj).id);
	}
	return equals;
    }

}
