package com.learn.spring.recipe.repositories;

import com.learn.spring.recipe.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
