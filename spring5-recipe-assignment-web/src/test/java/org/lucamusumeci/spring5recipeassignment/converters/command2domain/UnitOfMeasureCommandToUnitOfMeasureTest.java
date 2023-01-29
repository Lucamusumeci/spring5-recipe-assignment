package org.lucamusumeci.spring5recipeassignment.converters.command2domain;

import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.commands.UnitOfMeasureCommand;
import org.lucamusumeci.spring5recipeassignment.domain.UnitOfMeasure;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {

    UnitOfMeasureCommandToUnitOfMeasure converter = new UnitOfMeasureCommandToUnitOfMeasure();
    Long id = 1L;
    String name = "uom";
    String symbol = "u";

    @Test
    void convertNull(){
        assertNull(converter.convert(null));
    }

    @Test
    void convertEmpty(){
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    void convert() {
        UnitOfMeasure domain = UnitOfMeasure.builder().id(id).name(name).symbol(symbol).build();
        UnitOfMeasureCommand command = UnitOfMeasureCommand.builder().id(id).name(name).symbol(symbol).build();
        assertEquals(domain,converter.convert(command));
    }
}