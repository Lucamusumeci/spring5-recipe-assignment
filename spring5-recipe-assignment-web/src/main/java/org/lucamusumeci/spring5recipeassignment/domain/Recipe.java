package org.lucamusumeci.spring5recipeassignment.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int preparationTime;
    private int cookingTime;
    private int servings;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @Enumerated(EnumType.STRING)
    private Cost cost;
    @ManyToMany
    @JoinTable(name = "rel_recipe_category",
            joinColumns = @JoinColumn(name = "recipe"),
            inverseJoinColumns = @JoinColumn(name = "category"))
    final private Set<Category> categories = new HashSet<>();
    private int rating;
    @Lob
    private String description;
    @Lob
    private String instructions;
    @OneToMany(mappedBy = "recipe")
    final private Set<Ingredient> ingredients = new HashSet<>();
    @Lob
    private Byte[] image;
    private String url;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    public void addIngredient(Ingredient ingredient){
        if(ingredient.getId()==null){
            return;
        }
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
    }

}

