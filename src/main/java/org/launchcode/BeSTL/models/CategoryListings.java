package org.launchcode.BeSTL.models;

import java.util.HashMap;

/**
 * Created by estel on 7/15/2017.
 */
public class CategoryListings {

    public static HashMap<String, Integer> placeAndScore = new HashMap<>();

    public static HashMap<String, Integer> loadData() {
        placeAndScore.put("Mission Taco", 10);
        placeAndScore.put("Seoul Taco", 8);
        placeAndScore.put("Lona's Lil' Eats", 13);
        placeAndScore.put("Nachomama's", 4);
        placeAndScore.put("La Vallesana", 20);
        return placeAndScore;
    }






}
