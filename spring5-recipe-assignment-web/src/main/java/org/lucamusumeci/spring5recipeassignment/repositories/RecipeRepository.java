package org.lucamusumeci.spring5recipeassignment.repositories;

import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
