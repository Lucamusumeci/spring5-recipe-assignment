package org.lucamusumeci.spring5recipeassignment.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lucamusumeci.spring5recipeassignment.domain.UnitOfMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByName() {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByName("milliliter");
        assertTrue(unitOfMeasureOptional.isPresent());
        assertEquals("milliliter",unitOfMeasureOptional.get().getName());
        assertEquals("ml",unitOfMeasureOptional.get().getSymbol());
    }
}