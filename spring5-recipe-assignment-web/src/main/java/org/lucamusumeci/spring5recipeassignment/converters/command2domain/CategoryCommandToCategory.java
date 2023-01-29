package org.lucamusumeci.spring5recipeassignment.converters.command2domain;

import lombok.Synchronized;
import org.lucamusumeci.spring5recipeassignment.commands.CategoryCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if(source==null){
            return null;
        }
        return Category.builder()
                .id(source.getId())
                .name(source.getName())
            .build();
    }
}
