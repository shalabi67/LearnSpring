package com.learn.spring.recipe.models;

import com.learn.spring.recipe.models.mutable.MutableNote;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


@Getter
@Entity
@Table(name="Recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String description;
	protected Integer prepareTime;
	protected Integer cookTime;
	protected Integer servings;
	protected String source;
	protected String url;
	protected String directions;

	@Lob
	protected Byte[] image;

	@OneToOne(cascade = CascadeType.ALL)
	protected Note note;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	protected Set<Ingredient> ingredients = new HashSet<>();

	@Enumerated(EnumType.STRING)
	protected Difficulty difficulty;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name ="recipe_category",
			joinColumns = @JoinColumn(name ="recipe_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	protected Set<Category> categories = new HashSet<>();

	public Recipe() {
	}
	public Recipe(String description, Integer prepareTime, Integer cookTime, Integer servings, String source,
			String url, String directions, MutableNote note, Difficulty difficulty) {
		this.description = description;
		this.prepareTime = prepareTime;
		this.cookTime = cookTime;
		this.servings = servings;
		this.source = source;
		this.url = url;
		this.directions = directions;
		this.note = note;
		note.setRecipe(this);
		this.difficulty = difficulty;
	}
}
