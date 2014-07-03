package com.asai.jpa.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.asai.jpa.modal.Person;


public interface IPersonService  {

	 public void save(Person person);
	 public List<Person> findAll();
	 public List<Person> createNativeQuery(String query);
	 public List<Person> findByName(String name);

}
