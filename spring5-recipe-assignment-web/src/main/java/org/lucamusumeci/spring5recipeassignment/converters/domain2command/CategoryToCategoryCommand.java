package org.lucamusumeci.spring5recipeassignment.converters.domain2command;

import lombok.Synchronized;
import org.lucamusumeci.spring5recipeassignment.commands.CategoryCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if (source==null){
            return null;
        }
        return CategoryCommand.builder()
                .id(source.getId())
                .name(source.getName())
            .build();
    }
}
