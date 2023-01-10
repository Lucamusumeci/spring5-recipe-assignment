package org.lucamusumeci.spring5recipeassignment.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.lucamusumeci.spring5recipeassignment.repositories.RecipeRepository;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ListAllRecipeServiceTest {
    ListAllRecipeService service;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); //replaces MockitoAnnotations.initMocks(this) which is now deprecated
        service = new ListAllRecipeService(recipeRepository);
    }

    @Test
    void findAll() {
        Recipe recipe = new Recipe();
        HashSet recipesData= new HashSet();
        recipesData.add(recipe);

        Mockito.when(recipeRepository.findAll()).thenReturn(recipesData);
        Iterable<Recipe> recipes = service.findAll();
        Set<Recipe> recipeSet = new HashSet<>();
        recipes.forEach(recipeSet::add);

        assertEquals(recipeSet.size(),1);
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}