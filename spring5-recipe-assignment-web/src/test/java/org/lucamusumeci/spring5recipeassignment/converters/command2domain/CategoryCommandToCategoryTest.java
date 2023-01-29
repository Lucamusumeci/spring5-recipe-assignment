package org.lucamusumeci.spring5recipeassignment.converters.command2domain;

import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.commands.CategoryCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {

    CategoryCommandToCategory converter = new CategoryCommandToCategory();
    Long id = 1L;
    String name = "cat";


    @Test
    void convertNull(){
        assertNull(converter.convert(null));
    }

    @Test
    void convertEmpty(){
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    void convert(){
        CategoryCommand command = CategoryCommand.builder().id(id).name(name).build();
        Category domain = Category.builder().id(id).name(name).build();
        assertEquals(domain,converter.convert(command));
    }

}