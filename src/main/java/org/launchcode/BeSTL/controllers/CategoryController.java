package org.launchcode.BeSTL.controllers;

import org.launchcode.BeSTL.models.Category;
import org.launchcode.BeSTL.models.Restaurant;
import org.launchcode.BeSTL.models.data.CategoryDao;
import org.launchcode.BeSTL.models.data.RestaurantDao;
import org.launchcode.BeSTL.models.data.UserDao;
import org.launchcode.BeSTL.models.data.VoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.swing.JPanel;


import javax.swing.*;
import javax.validation.Valid;

/**
 * Created by estel on 7/15/2017.
 */
@Controller
@RequestMapping(value="category")
public class CategoryController {
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    RestaurantDao restaurantDao;
    @Autowired
    UserDao userDao;
    @Autowired
    VoteDao voteDao;

    @RequestMapping(value="")
    public String home(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("title", "Categories");
        return "category/index";
    }

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String displayAdd(Model model) {
        model.addAttribute("title", "Add Category");
        model.addAttribute(new Category());
        return "category/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAdd(Model model, @ModelAttribute @Valid Category category, Errors errors){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Category");
            return "category/add";
        }

        for (Category cat : categoryDao.findAll()){
            if (cat.getName().equals(category.getName())){
                model.addAttribute("title", "Add Category");

                return "redirect:/category/add";
            }
        }

        categoryDao.save(category);

        return "redirect:";
    }

    @RequestMapping(value = "rankTable/{id}", method = RequestMethod.GET)
    public String displayRankTable(Model model, @PathVariable int id) {

        Category cat = categoryDao.findOne(id);

        model.addAttribute(new Restaurant());

        model.addAttribute("category", cat);
        model.addAttribute("title", cat.getName());
        model.addAttribute("restaurants", restaurantDao.findByCategoryOrderByScoreDesc(cat));

        return "category/rankTable";
    }

    @RequestMapping(value = "rankTable", method = RequestMethod.POST)
    public String processAdd(@ModelAttribute  @Valid Restaurant newRestaurant,
                                       Errors errors,
                                       Model model,
                                       @RequestParam int categoryId) {


        if (errors.hasErrors()) {
            Category cat = categoryDao.findOne(categoryId);
            model.addAttribute("category", cat);
            model.addAttribute("restaurants", restaurantDao.findByCategoryOrderByScoreDesc(cat));
            return "category/rankTable";
        }



        Category cat = categoryDao.findOne(categoryId);
        newRestaurant.setCategory(cat);

        for (Restaurant rest : restaurantDao.findByCategoryOrderByScoreDesc(cat)){
            if (rest.getName().equals(newRestaurant.getName())){
                model.addAttribute("category", cat);
                model.addAttribute("restaurants", restaurantDao.findByCategoryOrderByScoreDesc(cat));
                return "category/rankTable";
            }
        }

        restaurantDao.save(newRestaurant);
        model.addAttribute("category", cat);
        model.addAttribute("restaurants", restaurantDao.findByCategoryOrderByScoreDesc(cat));



        return "redirect:/category/rankTable/" + cat.getId();
    }
}
