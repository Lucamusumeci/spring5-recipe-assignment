package org.lucamusumeci.spring5recipeassignment.converters.command2domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.commands.IngredientCommand;
import org.lucamusumeci.spring5recipeassignment.commands.RecipeCommand;
import org.lucamusumeci.spring5recipeassignment.commands.UnitOfMeasureCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Ingredient;
import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.lucamusumeci.spring5recipeassignment.domain.UnitOfMeasure;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCommandToRecipeTest {

    RecipeCommandToRecipe converter;
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
        converter = new RecipeCommandToRecipe(new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),new CategoryCommandToCategory());
    }

    @Test
    void convertNull(){
        assertNull(converter.convert(null));
    }

    @Test
    void convertEmpty(){
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    void convertNoIngredientsAndNoCategories() {
        Recipe domain = Recipe.builder().id(recipeId).name(name).rating(rating).url(url).build();
        RecipeCommand command = RecipeCommand.builder().id(recipeId).name(name).rating(rating).url(url).build();
        assertEquals(domain,converter.convert(command));
    }

    @Test
    void convertRecipeWithIngredients(){
        UnitOfMeasure uomDomain = UnitOfMeasure.builder().id(uomId).name(uomName).symbol(uomSymbol).build();
        Ingredient ingredientDomain1 = Ingredient.builder().id(ingredient1Id).amount(ingredientAmount).unitOfMeasure(uomDomain).build();
        Ingredient ingredientDomain2 = Ingredient.builder().id(ingredient2Id).amount(ingredientAmount).unitOfMeasure(uomDomain).build();
        Recipe recipeDomain = Recipe.builder().id(recipeId).name(name).rating(rating).url(url).build();
        recipeDomain.addIngredient(ingredientDomain1);
        recipeDomain.addIngredient(ingredientDomain2);

        UnitOfMeasureCommand uomCommand = UnitOfMeasureCommand.builder().id(uomId).name(uomName).symbol(uomSymbol).build();
        IngredientCommand ingredientCommand1 = IngredientCommand.builder().id(ingredient1Id).amount(ingredientAmount).unitOfMeasureCommand(uomCommand).build();
        IngredientCommand ingredientCommand2 = IngredientCommand.builder().id(ingredient2Id).amount(ingredientAmount).unitOfMeasureCommand(uomCommand).build();
        RecipeCommand recipeCommand = RecipeCommand.builder().id(recipeId).name(name).rating(rating).url(url).build();
        recipeCommand.addIngredient(ingredientCommand1);
        recipeCommand.addIngredient(ingredientCommand2);

        assertEquals(recipeDomain,converter.convert(recipeCommand));
    }
}