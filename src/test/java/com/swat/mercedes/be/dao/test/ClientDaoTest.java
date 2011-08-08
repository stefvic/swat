package com.swat.mercedes.be.dao.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.swat.mercedes.be.AbstractSwatTest;
import com.swat.mercedes.be.dao.ClientDao;
import com.swat.mercedes.be.entities.Client;

/**
 * @author Victor Stefoglo
 * 
 */
public class ClientDaoTest extends AbstractSwatTest {

    @Autowired
    ClientDao clientDao;

    @Test
    @Transactional
    public void addClient() {
	Client client = createMockClient();

	clientDao.save(client);
	clientDao.flushAndClear();
	Client clientFound = clientDao.getAll().iterator().next();

	assertEquals(client.getFirstName(), clientFound.getFirstName());
	assertEquals(client.getLastName(), clientFound.getLastName());

    }

    @Test
    @Transactional
    public void loadClient() {
	clientDao.save(createMockClient());
	assertEquals(1, clientDao.getAll().size());
    }

    static public Client createMockClient() {
	Client client = new Client();
	client.setFirstName("FirstName");
	client.setLastName("LastName");

	return client;
    }
}
