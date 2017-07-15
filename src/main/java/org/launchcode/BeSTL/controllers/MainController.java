package org.launchcode.BeSTL.controllers;

import org.launchcode.BeSTL.models.CategoryListings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * Created by estel on 7/15/2017.
 */
@Controller
@RequestMapping(value="table")
public class MainController {
/** testing 1 2 **/
    HashMap<String, Integer> placeAndScore = CategoryListings.loadData();

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("listings", placeAndScore);
        return "index";
    }

}
