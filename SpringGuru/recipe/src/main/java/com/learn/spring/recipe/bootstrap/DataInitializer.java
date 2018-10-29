package com.learn.spring.recipe.bootstrap;

import com.learn.spring.recipe.models.Category;
import com.learn.spring.recipe.models.Difficulty;
import com.learn.spring.recipe.models.Ingredient;
import com.learn.spring.recipe.models.Recipe;
import com.learn.spring.recipe.models.mutable.MutableNote;
import com.learn.spring.recipe.repositories.CategoryRepository;
import com.learn.spring.recipe.repositories.RecipeRepository;
import com.learn.spring.recipe.repositories.UnitOfMeasurementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

	private CategoryRepository categoryRepository;
	private UnitOfMeasurementRepository unitOfMeasurementRepository;
	private RecipeRepository recipeRepository;
	public DataInitializer(CategoryRepository categoryRepository,
			UnitOfMeasurementRepository unitOfMeasurementRepository,
			RecipeRepository recipeRepository) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasurementRepository = unitOfMeasurementRepository;
		this.recipeRepository = recipeRepository;


	}
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		log.debug("creating spicy Chicken recipe.");
		Recipe spicyGrilledChickenTacos = createRecipe("Spicy Grilled Chicken Tacos Recipe",
				"Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.",
				20, 15, 4,
				"Simply Recipes", "https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/",
				"",
				Difficulty.Easy
				);
		spicyChicken = getSpicyChickenIngredient(spicyGrilledChickenTacos);
		setCategories(spicyGrilledChickenTacos);
		recipeRepository.save(spicyGrilledChickenTacos);

	}

	private Recipe createRecipe(String description, String note, Integer prepareTime, Integer cookTime,
			Integer servings, String source,
			String url, String directions, Difficulty difficulty) {
		MutableNote recipeNote = new MutableNote(note);
		//Set<Ingredient>  ingredientSet = new HashSet<>(Arrays.asList(ingredients));
		Recipe recipe = new Recipe(description, prepareTime, cookTime, servings, source, url,
				directions, recipeNote, difficulty);

		return recipe;

	}

	private void setCategories(Recipe recipe) {
		Category mexicanCategory = categoryRepository.findById(3L).get();
		Category fastFoodCategory = categoryRepository.findById(4L).get();
		mexicanCategory.getRecipes().add(recipe);
		recipe.getCategories().add(mexicanCategory);

		fastFoodCategory.getRecipes().add(recipe);
		recipe.getCategories().add(fastFoodCategory);
	}

	private Ingredient[] getSpicyChickenIngredient(Recipe recipe) {
		Ingredient[] spicyChicken = {
				new Ingredient(recipe, "ancho chili powder", new BigDecimal(2), unitOfMeasurementRepository.findByName("Teaspoon")),
				new Ingredient(recipe, "dried oregano", new BigDecimal(1), unitOfMeasurementRepository.findByName("Teaspoon")),
				new Ingredient(recipe, "dried cumin", new BigDecimal(1), unitOfMeasurementRepository.findByName("Teaspoon")),
				new Ingredient(recipe, "salt", new BigDecimal(1/2), unitOfMeasurementRepository.findByName("Teaspoon")),
				new Ingredient(recipe, "sugar", new BigDecimal(1), unitOfMeasurementRepository.findByName("Teaspoon")),
				new Ingredient(recipe, "garlic, finely chopped", new BigDecimal(1), unitOfMeasurementRepository.findByName("Clove")),
				new Ingredient(recipe, "finely grated orange zest", new BigDecimal(1), unitOfMeasurementRepository.findByName("Teaspoon")),

				new Ingredient(recipe, "fresh-squeezed orange juice", new BigDecimal(3), unitOfMeasurementRepository.findByName("Teaspoon")),

				new Ingredient(recipe, "olive oil", new BigDecimal(2), unitOfMeasurementRepository.findByName("Teaspoon")),

				new Ingredient(recipe, "skinless, boneless chicken thighs", new BigDecimal(1.25), unitOfMeasurementRepository.findByName("Teaspoon"))
		};

		return spicyChicken;
	}
	private Ingredient[] spicyChicken;

}
