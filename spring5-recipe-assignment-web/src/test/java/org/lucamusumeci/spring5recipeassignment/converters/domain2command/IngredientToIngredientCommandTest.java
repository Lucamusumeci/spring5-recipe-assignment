package org.lucamusumeci.spring5recipeassignment.converters.domain2command;

import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.commands.IngredientCommand;
import org.lucamusumeci.spring5recipeassignment.commands.UnitOfMeasureCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Ingredient;
import org.lucamusumeci.spring5recipeassignment.domain.UnitOfMeasure;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {
    IngredientToIngredientCommand converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
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
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    void convert() {
        UnitOfMeasure unitOfMeasure = UnitOfMeasure.builder().id(uomId).build();
        UnitOfMeasureCommand unitOfMeasureCommand = UnitOfMeasureCommand.builder().id(uomId).build();
        Ingredient domain = Ingredient.builder().id(id).name(name).amount(amount).unitOfMeasure(unitOfMeasure).build();
        IngredientCommand command = IngredientCommand.builder().id(id).name(name).amount(amount).unitOfMeasureCommand(unitOfMeasureCommand).build();
        assertEquals(command,converter.convert(domain));
    }
}