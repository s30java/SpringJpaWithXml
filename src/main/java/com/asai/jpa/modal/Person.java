package com.asai.jpa.modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;


@Entity
@Table(name="person")
@NamedStoredProcedureQuery(name="getAllPersons_StoredProcedure",resultClasses=Person.class, procedureName="getAllPersons")
public class Person extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5991359271454398200L;
	private String name;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
