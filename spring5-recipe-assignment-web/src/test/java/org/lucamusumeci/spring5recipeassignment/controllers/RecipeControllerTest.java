package org.lucamusumeci.spring5recipeassignment.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.lucamusumeci.spring5recipeassignment.service.ListAllRecipeService;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class RecipeControllerTest {
    RecipeController recipeController;
    @Mock
    ListAllRecipeService listAllRecipeService;
    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeController = new RecipeController(listAllRecipeService);
    }

    @Test
    void testMockMVC() throws Exception {
        //given
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("recipe/list"));
    }

    @Test
    void getAll() {
        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        ArgumentCaptor<Set<Recipe>> setArgumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        when(listAllRecipeService.findAll()).thenReturn(recipes);

        //then
        assertEquals("recipe/list", recipeController.getAll(model));
        verify(listAllRecipeService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("recipes"), setArgumentCaptor.capture());
        assertEquals(1,setArgumentCaptor.getValue().size());
    }
}