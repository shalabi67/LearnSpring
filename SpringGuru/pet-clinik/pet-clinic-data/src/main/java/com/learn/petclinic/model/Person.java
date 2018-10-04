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
	private String address;
	private String city;
	private String phoneNumber;

	@OneToOne
	private Occupation occupation;

	@OneToMany
	private Set<Speciality> specialities = new HashSet<>();

	@OneToMany
	private Set<Pet> pets = new HashSet<>();

	public static Person create(Long id, String firstName, String lastName,
			String address, String city, String phoneNumber,
			Occupation occupation) {
		Person person = new Person(firstName, lastName, address, city, phoneNumber);
		person.id = id;
		person.occupation = occupation;

		return person;
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Person(String firstName, String lastName, String address, String city, String phoneNumber) {
		this(firstName, lastName);
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}

	public Person(String firstName, String lastName, String address, String city, String phoneNumber,
			Occupation occupation) {
		this(firstName, lastName, address, city, phoneNumber);
		this.occupation = occupation;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public Set<Speciality> getSpecialities() {
		return specialities;
	}
}
