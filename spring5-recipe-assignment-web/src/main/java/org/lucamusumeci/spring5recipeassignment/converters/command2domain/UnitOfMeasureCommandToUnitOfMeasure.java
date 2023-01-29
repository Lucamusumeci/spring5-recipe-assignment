package org.lucamusumeci.spring5recipeassignment.converters.command2domain;

import lombok.Synchronized;
import org.lucamusumeci.spring5recipeassignment.commands.UnitOfMeasureCommand;
import org.lucamusumeci.spring5recipeassignment.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {
    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if(source==null){
            return null;
        }
        return UnitOfMeasure.builder()
                .id(source.getId())
                .name(source.getName())
                .symbol(source.getSymbol())
                .build();
    }
}
