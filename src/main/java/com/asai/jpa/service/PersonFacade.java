package com.asai.jpa.service;

import org.springframework.stereotype.Repository;
import com.asai.jpa.facade.AbstractFacade;
import com.asai.jpa.modal.Person;


@Repository
public class PersonFacade extends AbstractFacade<Person> {

	
	public PersonFacade() {
        super(Person.class);
    }
	
	
	
}
