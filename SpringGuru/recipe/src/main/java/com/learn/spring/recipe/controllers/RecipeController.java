package com.learn.spring.recipe.controllers;

import com.learn.spring.recipe.models.Recipe;
import com.learn.spring.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RecipeController.URL)
public class RecipeController {
	static final String URL = "/recipe";
	private static final String MODEL = "recipe";
	public static final String VIEW = URL + "/view";



	private RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping("/view/{recipeId}")
	public String showRecipe(@PathVariable Long recipeId, Model model) {
		if(recipeId == null) {
			return IndexController.VIEW;
		}
		Recipe recipe = recipeService.getRecipe(recipeId);
		if(recipe == null) {
			return IndexController.VIEW;
		}
		model.addAttribute(MODEL, recipe);
		return VIEW;
	}

}
