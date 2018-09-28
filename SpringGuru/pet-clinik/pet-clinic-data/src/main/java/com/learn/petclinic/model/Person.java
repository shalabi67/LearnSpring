package com.learn.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Person extends BaseModel<Long> {
	private String firstName;
	private String lastName;
	@OneToOne
	private Occupation occupation;

	public static Person create(Long id, String firstName, String lastName, Occupation occupation) {
		Person person = new Person(firstName, lastName);
		person.id = id;
		person.occupation = occupation;

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

	public Occupation getOccupation() {
		return occupation;
	}
}
