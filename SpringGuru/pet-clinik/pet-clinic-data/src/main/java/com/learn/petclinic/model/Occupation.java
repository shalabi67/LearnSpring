package com.learn.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="occupations")
public class Occupation extends BaseModel<Short> {
	public static final String owner = "owner";
	public static final String vet = "vet";

	private String name;

	public Occupation() {

	}
	public Occupation(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
