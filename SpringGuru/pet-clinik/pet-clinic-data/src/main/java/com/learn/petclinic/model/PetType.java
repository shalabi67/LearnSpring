package com.learn.petclinic.model;

import javax.persistence.Entity;

@Entity
public class PetType extends BaseModel<Short> {
	private String name;

	public PetType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
