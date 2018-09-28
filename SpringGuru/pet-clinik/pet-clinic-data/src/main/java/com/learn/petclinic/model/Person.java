package com.learn.petclinic.model;

import javax.persistence.Entity;

@Entity
public class Person extends BaseModel<Long> {
	private String firstName;
	private String lastName;

	public static Person create(Long id, String firstName, String lastName) {
		Person person = new Person(firstName, lastName);
		person.id = id;

		return person;
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
