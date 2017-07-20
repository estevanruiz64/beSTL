package org.launchcode.BeSTL.controllers;

import org.launchcode.BeSTL.models.data.CategoryDao;
import org.launchcode.BeSTL.models.data.RestaurantDao;
import org.launchcode.BeSTL.models.data.VoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by estel on 7/20/2017.
 */
@Controller
@RequestMapping("restaurant")
public class RestaurantController {

    @Autowired
    CategoryDao categoryDao;
    @Autowired
    RestaurantDao restaurantDao;
    @Autowired
    VoteDao voteDao;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String displayRestaurantForm(Model model){
        model.addAttribute("restaurants", restaurantDao.findAll());
        model.addAttribute("title", "All Restaurants");

        return "index";
    }

}
