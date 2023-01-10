package org.lucamusumeci.spring5recipeassignment.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long amount;
    @ManyToOne
    private Recipe recipe;
    @OneToOne(fetch = FetchType.EAGER)
    //Each time Ingredient is loaded unit of measure is loaded as well. Default behavior for onetoone
    private UnitOfMeasure unitOfMeasure;


}
