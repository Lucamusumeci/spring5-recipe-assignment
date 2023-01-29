package org.lucamusumeci.spring5recipeassignment.service;

import java.util.Set;

/**
 *
 * @param <T> Domain object
 * @param <ID> Id object
 * @param <C> Command object
 */
public interface CrudService<T, ID, C> {
    Set<T> findAll();

    T findById(ID id);

    C saveCommand(C c);
}
