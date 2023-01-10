package org.lucamusumeci.spring5recipeassignment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Spring5RecipeAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5RecipeAssignmentApplication.class, args);
		log.info("@SpringBootApplication started");
	}
}