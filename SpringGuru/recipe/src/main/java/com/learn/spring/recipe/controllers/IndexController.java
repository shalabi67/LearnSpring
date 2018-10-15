package com.learn.spring.recipe.controllers;

import com.learn.spring.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

	private RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({"","/", "/index", "index.html", "index.htm"})
	public String showMainPage(Model model) {
		log.debug("IndexController::showMainPage had been called.");
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}
}
