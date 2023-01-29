package org.lucamusumeci.spring5recipeassignment.converters.command2domain;

import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.commands.IngredientCommand;
import org.lucamusumeci.spring5recipeassignment.commands.UnitOfMeasureCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Ingredient;
import org.lucamusumeci.spring5recipeassignment.domain.UnitOfMeasure;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {

    IngredientCommandToIngredient converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    Long id = 1L;
    Long uomId = 2L;
    Long amount = 3L;
    String name = "name";


    @Test
    void convertNull(){
        assertNull(converter.convert(null));
    }

    @Test
    void convertEmpty(){
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    void convert() {
        UnitOfMeasure unitOfMeasure = UnitOfMeasure.builder().id(uomId).build();
        UnitOfMeasureCommand unitOfMeasureCommand = UnitOfMeasureCommand.builder().id(uomId).build();
        IngredientCommand command = IngredientCommand.builder().id(id).name(name).amount(amount).unitOfMeasureCommand(unitOfMeasureCommand).build();
        Ingredient domain = Ingredient.builder().id(id).name(name).amount(amount).unitOfMeasure(unitOfMeasure).build();
        assertEquals(domain,converter.convert(command));
    }
}