package org.lucamusumeci.spring5recipeassignment.controllers;

import lombok.extern.slf4j.Slf4j;
import org.lucamusumeci.spring5recipeassignment.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("recipe")
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"all","all.html","list","list.htm"})
    public String getAll(Model model){
        log.info("Returning recipe/list");
        model.addAttribute("recipes", recipeService.findAll());
        return "recipe/list";
    }

    @RequestMapping({"show/{id}"})
    public String getRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe",recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }
}
