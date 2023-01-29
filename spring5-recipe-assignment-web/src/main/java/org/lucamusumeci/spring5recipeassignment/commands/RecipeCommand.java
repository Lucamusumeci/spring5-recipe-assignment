package org.lucamusumeci.spring5recipeassignment.commands;

import lombok.*;
import org.lucamusumeci.spring5recipeassignment.domain.Cost;
import org.lucamusumeci.spring5recipeassignment.domain.Difficulty;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class RecipeCommand {
    private Long id;
    private String name;
    private int preparationTime;
    private int cookingTime;
    private int servings;
    private Difficulty difficulty;
    private Cost cost;
    final private Set<CategoryCommand> categories = new HashSet<>();
    final private Set<IngredientCommand> ingredients = new HashSet<>();
    private int rating;
    private String description;
    private String instructions;
    private String url;

    public void addIngredient(IngredientCommand ingredient){
        if(ingredient.getId()==null){
            return;
        }
        this.ingredients.add(ingredient);
    }
}
