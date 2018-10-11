package com.learn.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pet_types")
public class PetType extends BaseModel<Short> {
	private String name;

	public PetType() {

	}
	public PetType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
