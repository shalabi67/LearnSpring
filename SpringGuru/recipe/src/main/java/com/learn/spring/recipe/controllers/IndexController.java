package com.learn.spring.recipe.controllers;

import com.learn.spring.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({"","/", "/index", "index.html", "index.htm"})
	public String showMainPage(Model model) {
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}
}
