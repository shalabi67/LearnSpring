package com.learn.petclinic.model;

import javax.persistence.Entity;

@Entity
public class Occupation extends BaseModel<Long> {
	public static final String owner = "owner";
	public static final String vet = "vet";

	private String name;

	public Occupation(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
