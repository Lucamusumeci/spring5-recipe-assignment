package org.lucamusumeci.spring5recipeassignment.converters.command2domain;

import lombok.AllArgsConstructor;
import lombok.Synchronized;
import org.lucamusumeci.spring5recipeassignment.commands.RecipeCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    IngredientCommandToIngredient ingredientconverter;
    CategoryCommandToCategory categoryConverter;


    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if(source==null){
            return null;
        }
        Recipe domain = Recipe.builder()
                .id(source.getId())
                .cost(source.getCost())
                .cookingTime(source.getCookingTime())
                .description(source.getDescription())
                .difficulty(source.getDifficulty())
                .url(source.getUrl())
                .name(source.getName())
                .rating(source.getRating())
                .preparationTime(source.getPreparationTime())
                .servings(source.getServings())
            .build();
        if(source.getIngredients()!=null){
            source.getIngredients().forEach(ingredientCommand -> domain.addIngredient(ingredientconverter.convert(ingredientCommand)));
        }
        if(source.getCategories()!=null){
            source.getCategories().forEach(categoryCommand -> domain.getCategories().add(categoryConverter.convert(categoryCommand)));
        }
        return domain;
    }
}
