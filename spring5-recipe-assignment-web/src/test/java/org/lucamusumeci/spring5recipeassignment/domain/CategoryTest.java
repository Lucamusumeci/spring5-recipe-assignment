package org.lucamusumeci.spring5recipeassignment.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CategoryTest {
    Category category;

    @BeforeEach
    void setUp() {
        log.info("@BeforeEach");
        category = new Category();
    }

    @Test
    void getId() {
        log.info("Testing getId");
        Long id = 1L;
        category.setId(id);
        assertEquals(id,category.getId());
    }
}