package org.lucamusumeci.spring5recipeassignment.service;

import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.lucamusumeci.spring5recipeassignment.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class ListAllRecipeService implements ListAllService<Recipe> {

    private final RecipeRepository recipeRepository;

    public ListAllRecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<Recipe> findAll() {
        return recipeRepository.findAll();
    }
}
