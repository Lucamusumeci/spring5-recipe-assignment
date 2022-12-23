package org.lucamusumeci.spring5recipeassignment.controllers;

import org.lucamusumeci.spring5recipeassignment.service.ListAllRecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("recipe")
@Controller
public class RecipeController {

    private final ListAllRecipeService listAllRecipeService;

    public RecipeController(ListAllRecipeService listAllRecipeService) {
        this.listAllRecipeService = listAllRecipeService;
    }

    @RequestMapping({"all","all.html","list","list.htm"})
    public String getAll(Model model){
        model.addAttribute("recipes", listAllRecipeService.findAll());
        return "recipe/list";
    }
}
