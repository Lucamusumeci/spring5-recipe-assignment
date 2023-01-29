package org.lucamusumeci.spring5recipeassignment.commands;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class IngredientCommand {
    private Long id;
    private String name;
    private Long amount;
    private UnitOfMeasureCommand unitOfMeasureCommand;
}
