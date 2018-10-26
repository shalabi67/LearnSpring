package com.learn.spring.recipe.services;

import com.learn.spring.recipe.models.Recipe;
import com.learn.spring.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
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
		log.debug("RecipeService::getRecipes had been called");
		return recipeRepository.findAll();
	}

	public Recipe getRecipe(Long recipeId) {
		return recipeRepository.findById(recipeId).orElseGet(null);
	}
}
