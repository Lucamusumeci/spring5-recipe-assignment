package org.lucamusumeci.spring5recipeassignment.service;

import org.lucamusumeci.spring5recipeassignment.commands.RecipeCommand;
import org.lucamusumeci.spring5recipeassignment.converters.command2domain.RecipeCommandToRecipe;
import org.lucamusumeci.spring5recipeassignment.converters.domain2command.RecipeToRecipeCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.lucamusumeci.spring5recipeassignment.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeService implements CrudService<Recipe, Long, RecipeCommand> {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe commandToDomain;
    private final RecipeToRecipeCommand domainToCommand;

    public RecipeService(RecipeRepository recipeRepository, RecipeCommandToRecipe commandToDomain, RecipeToRecipeCommand domainToCommand) {
        this.recipeRepository = recipeRepository;
        this.commandToDomain = commandToDomain;
        this.domainToCommand = domainToCommand;
    }

    @Override
    public Set<Recipe> findAll() {
        Set<Recipe> output = new HashSet<>();
        recipeRepository.findAll().forEach(output::add);
        return output;
    }

    @Override
    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    public RecipeCommand saveCommand(RecipeCommand recipeCommand) {
        if(recipeCommand==null){
            return null;
        }
        Recipe savedConvertedRecipe = recipeRepository.save(commandToDomain.convert(recipeCommand));
        return domainToCommand.convert(savedConvertedRecipe);
    }
}
