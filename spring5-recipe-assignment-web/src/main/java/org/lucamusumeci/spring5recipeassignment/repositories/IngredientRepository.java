package org.lucamusumeci.spring5recipeassignment.repositories;

import org.lucamusumeci.spring5recipeassignment.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
}
