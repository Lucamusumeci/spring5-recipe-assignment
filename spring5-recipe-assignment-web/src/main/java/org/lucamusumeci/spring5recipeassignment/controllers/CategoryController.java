package org.lucamusumeci.spring5recipeassignment.controllers;

import lombok.extern.slf4j.Slf4j;
import org.lucamusumeci.spring5recipeassignment.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("category")
@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    //@Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("testFindByName")
    public String testFindByName(Model model){
        log.info("Returning category/testFindByName");
        model.addAttribute("result", categoryRepository.findByName("Ethnic").get().getId());
        return "category/testFindByName";
    }

}
