package com.learn.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person extends BaseModel<Long> {
	private String firstName;
	private String lastName;
	@OneToOne
	private Occupation occupation;

	@OneToMany
	private Set<Pet> pets = new HashSet<>();

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

	public Set<Pet> getPets() {
		return pets;
	}
}
