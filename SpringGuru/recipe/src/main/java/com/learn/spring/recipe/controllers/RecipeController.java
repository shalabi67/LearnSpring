package com.learn.spring.recipe.controllers;

import com.learn.spring.recipe.models.Recipe;
import com.learn.spring.recipe.models.mutable.MutableRecipe;
import com.learn.spring.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(RecipeController.URL)
public class RecipeController {
	static final String URL = "/recipe";
	public static final String MODEL = "recipe";
	public static final String VIEW = URL + "/view";
	public static final String FORM = URL + "/recipeform";



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

	@RequestMapping("/new")
	public String createRecipeForm(Model model) {
		model.addAttribute(MODEL, new MutableRecipe());

		return FORM;
	}

	@RequestMapping(name = URL, method = RequestMethod.POST)
	public String saveRecipe(@ModelAttribute MutableRecipe recipe) {
		Recipe newRecipe = recipeService.saveRecipe(recipe);
		String redirectURL = "redirect:" + VIEW;
		if(recipe == null) {
			return redirectURL;
		}

		return redirectURL + "/" + newRecipe.getId();
	}

}
