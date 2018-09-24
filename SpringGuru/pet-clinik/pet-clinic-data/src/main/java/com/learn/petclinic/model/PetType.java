package com.learn.petclinic.model;

public class PetType extends BaseModel {
	private String name;

	public PetType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
