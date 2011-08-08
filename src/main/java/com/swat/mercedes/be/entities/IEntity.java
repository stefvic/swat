package com.swat.mercedes.be.entities;

import java.io.Serializable;

/**
 * Interface marks class which can be persisted.
 * 
 * @param <T>
 *            type of primary key, it must be serializable
 * 
 * @author Victor Stefoglo
 * 
 */
public interface IEntity<T extends Serializable> extends Serializable {

    String ID = "id";

    /**
     * Get primary key.
     * 
     * @return primary key
     */
    T getId();

    /**
     * Set primary key.
     * 
     * @param id
     *            primary key
     */
    void setId(T id);

}
