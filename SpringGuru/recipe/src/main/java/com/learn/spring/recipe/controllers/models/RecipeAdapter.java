package com.learn.spring.recipe.controllers.models;

import com.learn.spring.recipe.models.Recipe;
import com.learn.spring.recipe.models.mutable.MutableNote;
import com.learn.spring.recipe.models.mutable.MutableRecipe;

public class RecipeAdapter {
	public static Recipe convert(RecipeUI recipeUI) {
		MutableRecipe recipe = new MutableRecipe();
		recipe.setId(recipeUI.getId());
		recipe.setCookTime(recipeUI.getCookTime());
		recipe.setDescription(recipeUI.getDescription());
		recipe.setDifficulty(recipeUI.getDifficulty());
		recipe.setImage(recipeUI.getImage());
		MutableNote note = new MutableNote(recipeUI.getNote());
		note.setRecipe(recipe);
		recipe.setNote(note);
		recipe.setServings(recipeUI.getServings());
		recipe.setSource(recipeUI.getSource());
		recipe.setUrl(recipeUI.getUrl());
		return recipe;
	}

	public static RecipeUI convert(Recipe recipe) {
		RecipeUI recipeUI = new RecipeUI();
		recipeUI.setId(recipe.getId());
		recipeUI.setCookTime(recipe.getCookTime());
		recipeUI.setDescription(recipe.getDescription());
		recipeUI.setDifficulty(recipe.getDifficulty());
		recipeUI.setImage(recipe.getImage());
		recipeUI.setNote(recipe.getNote());
		recipeUI.setIngredients(recipe.getIngredients());
		recipeUI.setServings(recipe.getServings());
		recipeUI.setSource(recipe.getSource());
		recipeUI.setUrl(recipe.getUrl());
		return recipeUI;
	}

}
