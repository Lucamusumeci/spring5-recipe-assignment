package org.lucamusumeci.spring5recipeassignment.converters.command2domain;

import lombok.AllArgsConstructor;
import lombok.Synchronized;
import org.lucamusumeci.spring5recipeassignment.commands.IngredientCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter;

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source==null){
            return null;
        }
        return Ingredient.builder()
                .id(source.getId())
                .name(source.getName())
                .amount(source.getAmount())
                .unitOfMeasure(unitOfMeasureConverter.convert(source.getUnitOfMeasureCommand()))
            .build();
    }
}
