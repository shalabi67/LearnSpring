package com.learn.spring.recipe.services;

import com.learn.spring.recipe.models.Recipe;
import com.learn.spring.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

  	private RecipeRepository recipeRepository;

	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public Iterable<Recipe> getRecipes() {
		//Set<Recipe> recipes = new HashSet<>();
		//recipeRepository.findAll().forEach(recipe -> recipes.add(recipe));

		//return recipes;

		return recipeRepository.findAll();
	}
}
