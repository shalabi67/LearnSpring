package com.learn.spring.recipe.controllers.models;

import com.learn.spring.recipe.models.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeUI {
	private Long id;
	private String description;
	private Integer prepareTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	private String directions;
	private Difficulty difficulty;
	private String note;
	private Byte[] image;
}
