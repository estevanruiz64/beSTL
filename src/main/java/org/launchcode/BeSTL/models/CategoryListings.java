package org.launchcode.BeSTL.models;

import java.util.HashMap;

/**
 * Created by estel on 7/17/2017.
 */
public class CategoryListings {

    public static HashMap<String, HashMap> categories = new HashMap<>();

    public static HashMap<String, HashMap> loadData(){
        categories.put("burrito", PlaceAndScoreListings.burritos());
        categories.put("burger", PlaceAndScoreListings.burgers());
        categories.put("pasta", PlaceAndScoreListings.pasta());
        return categories;
    }

}
