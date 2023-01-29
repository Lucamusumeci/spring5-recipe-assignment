package org.lucamusumeci.spring5recipeassignment.commands;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CategoryCommand {
    private Long id;
    private String name;
}
