package org.lucamusumeci.spring5recipeassignment.converters.domain2command;

import lombok.Synchronized;
import org.lucamusumeci.spring5recipeassignment.commands.UnitOfMeasureCommand;
import org.lucamusumeci.spring5recipeassignment.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source==null){
            return null;
        }
        return UnitOfMeasureCommand.builder()
                .id(source.getId())
                .name(source.getName())
                .symbol(source.getSymbol())
            .build();
    }
}
