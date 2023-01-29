package org.lucamusumeci.spring5recipeassignment.converters.domain2command;

import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.commands.CategoryCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

class CategoryToCategoryCommandTest {

    CategoryToCategoryCommand converter = new CategoryToCategoryCommand();
    Long id = 1L;
    String name = "cat";

    @Test
    void convertNull(){
        assertNull(converter.convert(null));
    }

    @Test
    void convertEmpty(){
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    void convert() {
        Category domain = Category.builder().id(id).name(name).build();
        CategoryCommand command = CategoryCommand.builder().id(id).name(name).build();
        assertEquals(command,converter.convert(domain));
    }
}