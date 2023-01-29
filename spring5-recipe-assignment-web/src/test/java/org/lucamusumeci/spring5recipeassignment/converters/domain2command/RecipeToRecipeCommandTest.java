package org.lucamusumeci.spring5recipeassignment.converters.domain2command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.commands.IngredientCommand;
import org.lucamusumeci.spring5recipeassignment.commands.RecipeCommand;
import org.lucamusumeci.spring5recipeassignment.commands.UnitOfMeasureCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Ingredient;
import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.lucamusumeci.spring5recipeassignment.domain.UnitOfMeasure;

import static org.junit.jupiter.api.Assertions.*;

class RecipeToRecipeCommandTest {

    RecipeToRecipeCommand converter;
    Long recipeId = 1L;
    String name = "recipe";
    String url = "url";
    int rating = 2;
    Long ingredient1Id = 10L;
    Long ingredient2Id = 20L;
    String ingredient1Name = "ingredient1";
    String ingredient2Name = "ingredient2";
    Long ingredientAmount = 100L;
    Long uomId = 3L;
    String uomName = "uom";
    String uomSymbol = "u";



    @BeforeEach
    void setUp() {
        converter = new RecipeToRecipeCommand(
                new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
                new CategoryToCategoryCommand());
    }

    @Test
    void convertNull(){
        assertNull(converter.convert(null));
    }

    @Test
    void convertEmpty(){
        assertNotNull(converter.convert(new Recipe()));
    }

    @Test
    void convertNoIngredientsAndNoCategories() {
        Recipe domain = Recipe.builder().id(recipeId).name(name).rating(rating).url(url).build();
        RecipeCommand command = RecipeCommand.builder().id(recipeId).name(name).rating(rating).url(url).build();
        assertEquals(command,converter.convert(domain));
    }

    @Test
    void convertRecipeWithIngredients(){
        UnitOfMeasure uomDomain = UnitOfMeasure.builder().id(uomId).name(uomName).symbol(uomSymbol).build();
        Ingredient ingredientDomain1 = Ingredient.builder().id(ingredient1Id).name(ingredient1Name).amount(ingredientAmount).unitOfMeasure(uomDomain).build();
        Ingredient ingredientDomain2 = Ingredient.builder().id(ingredient2Id).name(ingredient2Name).amount(ingredientAmount).unitOfMeasure(uomDomain).build();
        Recipe recipeDomain = Recipe.builder().id(recipeId).name(name).rating(rating).url(url).build();
        recipeDomain.addIngredient(ingredientDomain1);
        recipeDomain.addIngredient(ingredientDomain2);

        UnitOfMeasureCommand uomCommand = UnitOfMeasureCommand.builder().id(uomId).name(uomName).symbol(uomSymbol).build();
        IngredientCommand ingredientCommand1 = IngredientCommand.builder().id(ingredient1Id).name(ingredient1Name).amount(ingredientAmount).unitOfMeasureCommand(uomCommand).build();
        IngredientCommand ingredientCommand2 = IngredientCommand.builder().id(ingredient2Id).name(ingredient2Name).amount(ingredientAmount).unitOfMeasureCommand(uomCommand).build();
        RecipeCommand recipeCommand = RecipeCommand.builder().id(recipeId).name(name).rating(rating).url(url).build();
        recipeCommand.addIngredient(ingredientCommand1);
        recipeCommand.addIngredient(ingredientCommand2);

        assertEquals(recipeCommand,converter.convert(recipeDomain));
    }
}