package org.lucamusumeci.spring5recipeassignment.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
