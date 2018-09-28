package com.learn.petclinic.model;

import javax.persistence.Entity;

@Entity
public class Occupation extends BaseModel<Long> {
	private String name;

	public Occupation(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
