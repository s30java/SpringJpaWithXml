package com.asai.jpa.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.asai.jpa.facade.AbstractFacade;
import com.asai.jpa.modal.Person;
import com.asai.jpa.repositories.Personrepository;


@Repository
@Transactional(readOnly = true)
public class PersonServiceImpl extends AbstractFacade<Person> implements IPersonService {

	public PersonServiceImpl() {
        super(Person.class);
    }
	/**
	 * PersonFacade gets all the CRUD methods, we are using this facade just to get support for stored procedures
	 * 	 
	 */
	@Autowired
	PersonFacade personFacade;
	
	/**
	 * By using PersonRepository we will be getting all the default capabilities for the app
	 */
	@Autowired
	Personrepository personRepo;
	
	public void save(Person person) {

		personRepo.save(person);
	}

	@Override
	public List<Person> findAll() {
		
		return personRepo.findAll();
	}

	  /**
     * 
     * @param stored procedure/sql
     * @return resultset
     */

	public List<Person> createNativeQuery(String query){
    	
		List<Person> personlist=personFacade.createNativeQuery(query);
    	
    	return personlist;
    }

	@Override
	public List<Person> findByName(String name) {
		// TODO Auto-generated method stub
		return personRepo.findByName(name);
	}

}
