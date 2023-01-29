package org.lucamusumeci.spring5recipeassignment.commands;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class UnitOfMeasureCommand {
    private Long id;
    private String name;
    private String symbol;
}
