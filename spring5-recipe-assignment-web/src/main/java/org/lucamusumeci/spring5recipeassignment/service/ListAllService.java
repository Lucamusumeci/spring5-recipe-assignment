package org.lucamusumeci.spring5recipeassignment.service;

public interface ListAllService<T> {
    Iterable<T> findAll();
}
