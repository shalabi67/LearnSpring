package com.learn.petclinic.model;

import javax.persistence.Entity;

@Entity
public class Speciality extends BaseModel<Short> {
	private String name;

	public Speciality() {

	}

	public Speciality(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
