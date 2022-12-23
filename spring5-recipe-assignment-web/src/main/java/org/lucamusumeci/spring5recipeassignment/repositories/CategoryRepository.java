package org.lucamusumeci.spring5recipeassignment.repositories;

import org.lucamusumeci.spring5recipeassignment.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    Optional<Category> findByName(String name);
}
