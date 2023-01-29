package org.lucamusumeci.spring5recipeassignment.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.lucamusumeci.spring5recipeassignment.service.RecipeService;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

class RecipeControllerTest {
    RecipeController recipeController;
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeController = new RecipeController(recipeService);
    }

    @Test
    void mvcGetAll() throws Exception {
        //given
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        //then
        mockMvc.perform(get("/recipe/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/list"))
                .andExpect(model().attributeExists("recipes"));
    }

    @Test
    void getAll() {
        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        ArgumentCaptor<Set<Recipe>> setArgumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        when(recipeService.findAll()).thenReturn(recipes);

        //then
        assertEquals("recipe/list", recipeController.getAll(model));
        verify(recipeService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("recipes"), setArgumentCaptor.capture());
        assertEquals(1,setArgumentCaptor.getValue().size());
    }

    @Test
    void mvcGetRecipe() throws Exception {
        //given
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        //then
        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
    }

    @Test
    void getRecipe(){
        Long id = 1L;
        when(recipeService.findById(anyLong())).thenReturn(Recipe.builder().id(id).build());
        assertEquals("recipe/show",recipeController.getRecipe(String.valueOf(id),model));
        verify(recipeService,times(1)).findById(anyLong());
    }
}