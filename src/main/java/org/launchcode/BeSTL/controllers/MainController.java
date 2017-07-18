package org.launchcode.BeSTL.controllers;

import org.launchcode.BeSTL.models.CategoryListings;
import org.launchcode.BeSTL.models.PlaceAndScoreListings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by estel on 7/15/2017.
 */
@Controller
@RequestMapping(value="")
public class MainController {
/** testing 1 2 **/

    HashMap<String, Integer> placeAndScoreBurritos = PlaceAndScoreListings.burritos();
    HashMap<String, Integer> placeAndScoreBurgers = PlaceAndScoreListings.burgers();
    HashMap<String, Integer> placeAndScorePasta = PlaceAndScoreListings.pasta();
    HashMap<String, HashMap> categories = CategoryListings.loadData();

    @RequestMapping(value="")
    @ResponseBody
    public String users(Model model) {
        return "this is where I would put user signup... IF I HAD ONE!";
    }

    @RequestMapping(value="display")
    public String home(Model model) {
        model.addAttribute("categories", categories);
        return "home";
    }


    @RequestMapping(value="display/burrito")
    public String index1(Model model) {
        model.addAttribute("listings", placeAndScoreBurritos);

        return "display";
    }
    @RequestMapping(value="display/burger")
    public String index2(Model model) {
        model.addAttribute("listings", placeAndScoreBurgers);

        return "display";
    }
    @RequestMapping(value="display/pasta")
    public String index3(Model model) {
        model.addAttribute("listings", placeAndScorePasta);

        return "display";
    }

}
