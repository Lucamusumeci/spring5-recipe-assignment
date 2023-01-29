package org.lucamusumeci.spring5recipeassignment.converters.domain2command;

import lombok.AllArgsConstructor;
import lombok.Synchronized;
import org.lucamusumeci.spring5recipeassignment.commands.IngredientCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter;
    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source==null){
            return null;
        }
        return IngredientCommand.builder()
                .id(source.getId())
                .name(source.getName())
                .amount(source.getAmount())
                .unitOfMeasureCommand(unitOfMeasureConverter.convert(source.getUnitOfMeasure()))
            .build();
    }
}
