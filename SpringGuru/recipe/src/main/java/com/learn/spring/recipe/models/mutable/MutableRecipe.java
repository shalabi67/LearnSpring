package com.learn.spring.recipe.models.mutable;

import com.learn.spring.recipe.models.Category;
import com.learn.spring.recipe.models.Difficulty;
import com.learn.spring.recipe.models.Ingredient;
import com.learn.spring.recipe.models.Note;
import com.learn.spring.recipe.models.Recipe;

import java.util.Set;

public class MutableRecipe extends Recipe {
	public MutableRecipe() {
		note = new MutableNote("");
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrepareTime(Integer prepareTime) {
		this.prepareTime = prepareTime;
	}

	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}

	public void setServings(Integer servings) {
		this.servings = servings;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
