package com.learn.spring.recipe.models;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;

	public Ingredient() {

	}

	public Ingredient(String description, BigDecimal amount,
			UnitOfMeasurement unitOfMeasurement) {
		this.description = description;
		this.amount = amount;
		this.unitOfMeasurement = unitOfMeasurement;
	}
	public Ingredient(Recipe recipe, String description, BigDecimal amount,
			Optional<UnitOfMeasurement> unitOfMeasurement) {
		this.description = description;
		this.amount = amount;
		this.recipe = recipe;
		recipe.getIngredients().add(this);
		if(unitOfMeasurement.isPresent()) {
			this.unitOfMeasurement = unitOfMeasurement.get();
		}
	}

	@ManyToOne
	private Recipe recipe;

	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasurement unitOfMeasurement;

}
