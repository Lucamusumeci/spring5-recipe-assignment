package org.lucamusumeci.spring5recipeassignment.service;

import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.lucamusumeci.spring5recipeassignment.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ListAllRecipeService implements ListAllService<Recipe> {

    private final RecipeRepository recipeRepository;

    public ListAllRecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> findAll() {
        Set<Recipe> output = new HashSet<>();
        recipeRepository.findAll().forEach(output::add);
        return output;
    }
}
