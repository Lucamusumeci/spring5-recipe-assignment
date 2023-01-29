package org.lucamusumeci.spring5recipeassignment.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lucamusumeci.spring5recipeassignment.commands.RecipeCommand;
import org.lucamusumeci.spring5recipeassignment.converters.command2domain.RecipeCommandToRecipe;
import org.lucamusumeci.spring5recipeassignment.converters.domain2command.RecipeToRecipeCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.lucamusumeci.spring5recipeassignment.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RecipeServiceIT {

    @Autowired
    RecipeService service;
    @Autowired
    RecipeRepository repository;
    @Autowired
    RecipeToRecipeCommand domainToCommand;
    @Autowired
    RecipeCommandToRecipe commandToDomain;

    @Transactional  //because of findAll
    @Test
    void saveDescription() {
        String newDescription = "newDesc";
        Recipe foundRecipe = service.findAll().stream().findFirst().get();
        RecipeCommand recipeCommand = domainToCommand.convert(foundRecipe);
        recipeCommand.setDescription(newDescription);
        Recipe convertedRecipe = commandToDomain.convert(recipeCommand);

        assertEquals(newDescription,convertedRecipe.getDescription());
        assertNotEquals(foundRecipe.getDescription(),convertedRecipe.getDescription());
        assertEquals(foundRecipe.getId(),convertedRecipe.getId());
        assertEquals(foundRecipe.getCategories().size(),convertedRecipe.getCategories().size());
    }
}
