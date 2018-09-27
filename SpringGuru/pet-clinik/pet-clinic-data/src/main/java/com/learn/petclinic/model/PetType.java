package com.learn.petclinic.model;

public class PetType extends BaseModel<Long> {
	private String name;

	public PetType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
