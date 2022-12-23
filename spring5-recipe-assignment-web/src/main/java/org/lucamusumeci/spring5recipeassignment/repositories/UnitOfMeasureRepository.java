package org.lucamusumeci.spring5recipeassignment.repositories;

import org.lucamusumeci.spring5recipeassignment.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {
    Optional<UnitOfMeasure> findByName(String name);
}
