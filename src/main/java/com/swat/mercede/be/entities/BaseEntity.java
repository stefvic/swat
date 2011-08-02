package com.swat.mercede.be.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Base entity class
 * 
 * @author Victor Stefoglo
 * 
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

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
    protected Long getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    void setId(Long id) {
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

}
