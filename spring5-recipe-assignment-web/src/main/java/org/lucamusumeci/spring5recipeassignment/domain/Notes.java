package org.lucamusumeci.spring5recipeassignment.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob    //To become a CLOB
    private String notes;
    @OneToOne
    private Recipe recipe;

}
