package com.learn.spring.recipe.models.mutable;

import com.learn.spring.recipe.models.Note;
import com.learn.spring.recipe.models.Recipe;
import lombok.Synchronized;

public class MutableNote extends Note {
	public MutableNote(Note recipeNote) {
		this(recipeNote.getRecipeNote());
		this.setId(recipeNote.getId());
		this.setRecipe(recipeNote.getRecipe());
	}
	public MutableNote(String recipeNote) {
		this.recipeNote = recipeNote;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Synchronized
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public void setRecipeNote(String recipeNote) {
		this.recipeNote = recipeNote;
	}
}
