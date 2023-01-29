package org.lucamusumeci.spring5recipeassignment.converters.domain2command;

import lombok.AllArgsConstructor;
import lombok.Synchronized;
import org.lucamusumeci.spring5recipeassignment.commands.RecipeCommand;
import org.lucamusumeci.spring5recipeassignment.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    IngredientToIngredientCommand ingredientConverter;
    CategoryToCategoryCommand categoryConverter;

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if(source==null){
            return null;
        }
        RecipeCommand command = RecipeCommand.builder()
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
            source.getIngredients().forEach(ingredient -> command.addIngredient(ingredientConverter.convert(ingredient)));
        }
        if(source.getCategories()!=null){
            source.getCategories().forEach(category -> command.getCategories().add(categoryConverter.convert(category)));
        }
        return command;
    }
}
