package com.learn.spring.recipe.models;

import com.learn.spring.recipe.models.mutable.MutableNote;

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
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Integer prepareTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	private String directions;
	@Lob
	private Byte[] image;
	@OneToOne(cascade = CascadeType.ALL)
	private Note note;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();

	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name ="recipe_category",
			joinColumns = @JoinColumn(name ="recipe_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();

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

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Integer getPrepareTime() {
		return prepareTime;
	}

	public Integer getCookTime() {
		return cookTime;
	}

	public Integer getServings() {
		return servings;
	}

	public String getSource() {
		return source;
	}

	public String getUrl() {
		return url;
	}

	public String getDirections() {
		return directions;
	}

	public Byte[] getImage() {
		return image;
	}

	public Note getNote() {
		return note;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public Set<Category> getCategories() {
		return categories;
	}
}
