package com.learn.spring.recipe.models;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class UnitOfMeasurement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	private String name;

}
