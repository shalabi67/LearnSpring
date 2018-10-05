package com.learn.spring.recipe.models.mutable;

import com.learn.spring.recipe.models.Note;
import com.learn.spring.recipe.models.Recipe;

public class MutableNote extends Note {
	public MutableNote(String recipeNote) {
		this.recipeNote = recipeNote;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public void setRecipeNote(String recipeNote) {
		this.recipeNote = recipeNote;
	}
}
