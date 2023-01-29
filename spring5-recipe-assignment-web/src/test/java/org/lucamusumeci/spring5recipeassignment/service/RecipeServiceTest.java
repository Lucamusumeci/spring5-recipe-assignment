package org.lucamusumeci.spring5recipeassignment.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.commands.RecipeCommand;
import org.lucamusumeci.spring5recipeassignment.converters.command2domain.RecipeCommandToRecipe;
import org.lucamusumeci.spring5recipeassignment.converters.domain2command.RecipeToRecipeCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.lucamusumeci.spring5recipeassignment.repositories.RecipeRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


class RecipeServiceTest {
    RecipeService recipeService;
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeCommandToRecipe commandToDomain;
    @Mock
    RecipeToRecipeCommand domainToCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); //replaces MockitoAnnotations.initMocks(this) which is now deprecated
        recipeService = new RecipeService(recipeRepository, commandToDomain, domainToCommand);
    }

    @Test
    void findAll() {
        Recipe recipe = new Recipe();
        HashSet recipesData= new HashSet();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);
        Iterable<Recipe> recipes = recipeService.findAll();
        Set<Recipe> recipeSet = new HashSet<>();
        recipes.forEach(recipeSet::add);

        assertEquals(recipeSet.size(),1);
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        long id = 1L;
        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(Recipe.builder().id(id).build()));
        Recipe foundRecipe = recipeService.findById(id);
        assertNotNull(foundRecipe);
        assertEquals(id, foundRecipe.getId());
        verify(recipeRepository,times(1)).findById(anyLong());
        verify(recipeRepository, times(0)).findAll();
    }

    @Test
    void saveCommandNull() {
        assertNull(recipeService.saveCommand(null));
    }

    @Test
    void saveCommand() {
        //given
        long id = 1L;
        String name = "name";
        RecipeCommand recipeCommand = RecipeCommand.builder().id(id).name(name).build();
        Recipe recipe = Recipe.builder().id(id).name(name).build();
        //when
        when(recipeRepository.save(any())).thenReturn(recipe);
        when(domainToCommand.convert(any())).thenReturn(recipeCommand);
        when(commandToDomain.convert(any())).thenReturn(recipe);
        //then
        assertEquals(recipeCommand, recipeService.saveCommand(recipeCommand));
        verify(domainToCommand, times(1)).convert(any());
        verify(commandToDomain, times(1)).convert(any());
    }
}