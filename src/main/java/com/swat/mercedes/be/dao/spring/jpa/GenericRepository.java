package com.swat.mercedes.be.dao.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swat.mercedes.be.entities.Client;

public abstract class GenericRepository implements JpaRepository<Client, Long> {

}
