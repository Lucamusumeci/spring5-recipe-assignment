package org.lucamusumeci.spring5recipeassignment.controllers;

import lombok.extern.slf4j.Slf4j;
import org.lucamusumeci.spring5recipeassignment.service.ListAllRecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("recipe")
@Controller
public class RecipeController {

    private final ListAllRecipeService listAllRecipeService;

    public RecipeController(ListAllRecipeService listAllRecipeService) {
        this.listAllRecipeService = listAllRecipeService;
    }

    @RequestMapping({"all","all.html","list","list.htm"})
    public String getAll(Model model){
        log.info("Returning recipe/list");
        model.addAttribute("recipes", listAllRecipeService.findAll());
        return "recipe/list";
    }
}
