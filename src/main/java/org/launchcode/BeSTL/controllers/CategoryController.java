package org.launchcode.BeSTL.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by estel on 7/15/2017.
 */
@Controller
@RequestMapping(value="category")
public class CategoryController {

    @RequestMapping(value="")
    public String home(Model model) {
        return "display";
    }



}
