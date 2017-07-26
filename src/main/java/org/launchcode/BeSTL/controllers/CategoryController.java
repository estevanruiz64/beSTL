package org.launchcode.BeSTL.controllers;

import org.launchcode.BeSTL.models.Category;
import org.launchcode.BeSTL.models.Restaurant;
import org.launchcode.BeSTL.models.User;
import org.launchcode.BeSTL.models.Vote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by estel on 7/15/2017.
 */
@Controller
@RequestMapping(value="category")
public class CategoryController extends AbstractController {

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
            model.addAttribute("error", "");

            return "category/add";
        }

        for (Category cat : categoryDao.findAll()){
            if (cat.getName().equals(category.getName())){
                model.addAttribute("title", "Add Category");
                model.addAttribute("error", "This category already exists.");
                return "category/add";
            }
        }

        model.addAttribute("error", "");
        categoryDao.save(category);

        return "redirect:";
    }

    @RequestMapping(value = "rankTable/{id}", method = RequestMethod.GET)
    public String displayRankTable(Model model, @PathVariable int id) {

        Category cat = categoryDao.findOne(id);

        model.addAttribute(new Restaurant());
        model.addAttribute(new Vote());

        model.addAttribute("category", cat);
        model.addAttribute("title", cat.getName());
        model.addAttribute("restaurants", restaurantDao.findByCategoryOrderByScoreDesc(cat));

        return "category/rankTable";
    }

    @RequestMapping(value = "rankTable/upVote", method = RequestMethod.POST)
    public String processVote(Model model,
                              Vote newVote,
                              @RequestParam int categoryId,
                              @RequestParam int restId,
                              HttpServletRequest request){

        Category cat = categoryDao.findOne(categoryId);
        Restaurant rest = restaurantDao.findOne(restId);
        User user = getUserFromSession(request.getSession());

        if (voteDao.findByUserAndRestaurant(user, rest).size() >= 1){
            model.addAttribute("title", cat.getName());
            model.addAttribute("error", "");
            model.addAttribute("category", cat);
            model.addAttribute("restaurants", restaurantDao.findByCategoryOrderByScoreDesc(cat));

            return "redirect:/category/rankTable/" + cat.getUid();
        }

        newVote.setUser(user);
        voteDao.save(newVote);
        rest.addVote(newVote);
        restaurantDao.save(rest);

        model.addAttribute("title", cat.getName());
        model.addAttribute("error", "");
        model.addAttribute("category", cat);
        model.addAttribute("restaurants", restaurantDao.findByCategoryOrderByScoreDesc(cat));

        return "redirect:/category/rankTable/" + cat.getUid();

    }


    @RequestMapping(value = "rankTable", method = RequestMethod.POST)
    public String processAdd(@ModelAttribute  @Valid Restaurant newRestaurant,
                                       Errors errors,
                                       Model model,
                                       @RequestParam int categoryId) {


        if (errors.hasErrors()) {
            Category cat = categoryDao.findOne(categoryId);
            model.addAttribute("title", cat.getName());
            model.addAttribute("error", "");
            model.addAttribute("category", cat);
            model.addAttribute("restaurants", restaurantDao.findByCategoryOrderByScoreDesc(cat));
            return "category/rankTable";
        }



        Category cat = categoryDao.findOne(categoryId);
        newRestaurant.setCategory(cat);

        for (Restaurant rest : restaurantDao.findByCategoryOrderByScoreDesc(cat)){
            if (rest.getName().equals(newRestaurant.getName())){
                model.addAttribute("title", cat.getName());
                model.addAttribute("category", cat);
                model.addAttribute("restaurants", restaurantDao.findByCategoryOrderByScoreDesc(cat));
                model.addAttribute("error", "This restaurant already exists in this category.");
                return "category/rankTable";
            }
        }

        restaurantDao.save(newRestaurant);
        model.addAttribute("title", cat.getName());
        model.addAttribute("error", "");
        model.addAttribute("category", cat);
        model.addAttribute("restaurants", restaurantDao.findByCategoryOrderByScoreDesc(cat));



        return "redirect:/category/rankTable/" + cat.getUid();
    }
}
