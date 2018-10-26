package com.learn.spring.recipe.controllers;

import com.learn.spring.recipe.models.Recipe;
import com.learn.spring.recipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
public class RecipeControllerTest {

	@Mock
	RecipeService recipeService;

	RecipeController recipeController;

	Recipe recipe = null;

	MockMvc mockMvc;
	private  String url;

	@Before
	public void setup() {
		when(recipeService.getRecipe(any())).thenReturn(recipe);


		recipeController = new RecipeController(recipeService);

		mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

	}

	@Test
	public void testNonExitingRecipe() throws Exception {
		url = RecipeController.VIEW + "/" + 1;
		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.andExpect(view().name(IndexController.VIEW));
	}

	@Test
	public void testNullId() throws Exception {
		url = RecipeController.VIEW + "/";
		mockMvc.perform(get(url))
				.andExpect(status().is4xxClientError());
	}

	@Test
	public void testInvalidId() throws Exception {
		url = RecipeController.VIEW + "/" + -1;
		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.andExpect(view().name(IndexController.VIEW));
	}
	@Test
	public void testExitingRecipe() throws Exception {
		recipe = new Recipe();
		when(recipeService.getRecipe(any())).thenReturn(recipe);
		url = RecipeController.VIEW + "/" + 1;

		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.andExpect(view().name(RecipeController.VIEW));
	}

}
