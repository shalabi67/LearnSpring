package com.learn.spring.recipe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitOfMeasurement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	private String name;

	public Short getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
