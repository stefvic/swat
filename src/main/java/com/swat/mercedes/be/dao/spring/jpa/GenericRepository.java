package com.swat.mercedes.be.dao.spring.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericRepository<T, ID extends Serializable> implements JpaRepository<T, ID> {
    
}
