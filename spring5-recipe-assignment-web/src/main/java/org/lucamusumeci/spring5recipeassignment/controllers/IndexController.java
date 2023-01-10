package org.lucamusumeci.spring5recipeassignment.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    @RequestMapping({"","/","index","index.html"})
    public String getIndexPage(){
        log.info("Returning index");
        return "index";
    }
}
