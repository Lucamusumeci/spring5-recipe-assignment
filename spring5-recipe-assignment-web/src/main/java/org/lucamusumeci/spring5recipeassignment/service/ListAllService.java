package org.lucamusumeci.spring5recipeassignment.service;

import java.util.Set;

public interface ListAllService<T> {
    Set<T> findAll();
}
