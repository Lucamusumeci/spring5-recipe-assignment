package org.lucamusumeci.spring5recipeassignment.repositories;

import org.lucamusumeci.spring5recipeassignment.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
