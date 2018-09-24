package com.learn.petclinic.model;

public class Person extends BaseModel {
	private String firstName;
	private String lastName;
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
