package org.lucamusumeci.spring5recipeassignment.converters.domain2command;

import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.commands.UnitOfMeasureCommand;
import org.lucamusumeci.spring5recipeassignment.domain.UnitOfMeasure;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureToUnitOfMeasureCommandTest {

    UnitOfMeasureToUnitOfMeasureCommand converter = new UnitOfMeasureToUnitOfMeasureCommand();
    Long id = 1L;
    String name = "uom";
    String symbol = "u";

    @Test
    void convertNull(){
        assertNull(converter.convert(null));
    }

    @Test
    void convertEmpty(){
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    void convert() {
        UnitOfMeasureCommand command = UnitOfMeasureCommand.builder().id(id).name(name).symbol(symbol).build();
        UnitOfMeasure domain = UnitOfMeasure.builder().id(id).name(name).symbol(symbol).build();
        assertEquals(command,converter.convert(domain));
    }
}