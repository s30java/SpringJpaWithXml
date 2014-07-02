package com.asai.jpa.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.asai.jpa.modal.Person;

public interface Personrepository extends JpaRepository<Person, Integer> {

	/**
     * Find persons by first and last name.
     * 
     * please add @query to define a customized query here
     */
    public List<Person> findByName(@Param("name") String Name);

}
