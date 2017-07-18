package org.launchcode.BeSTL.models;

import java.util.HashMap;

/**
 * Created by estel on 7/15/2017.
 */
public class PlaceAndScoreListings {

    public static HashMap<String, Integer> placeAndScoreBurritos = new HashMap<>();
    public static HashMap<String, Integer> placeAndScoreBurgers = new HashMap<>();
    public static HashMap<String, Integer> placeAndScorePasta = new HashMap<>();

    public static HashMap<String, Integer> burritos() {
        placeAndScoreBurritos.put("Mission Taco", 10);
        placeAndScoreBurritos.put("Seoul Taco", 8);
        placeAndScoreBurritos.put("Lona's Lil' Eats", 13);
        placeAndScoreBurritos.put("Nachomama's", 4);
        placeAndScoreBurritos.put("La Vallesana", 20);
        return placeAndScoreBurritos;
    }

    public static HashMap<String, Integer> burgers(){
        placeAndScoreBurgers.put("Red Robin", 3);
        placeAndScoreBurgers.put("Five Star Burgers", 11);
        placeAndScoreBurgers.put("Steak 'n Shake", 12);
        placeAndScoreBurgers.put("Olive + Oak", 25);
        return placeAndScoreBurgers;
    }

    public static HashMap<String, Integer> pasta(){
        placeAndScorePasta.put("Charlie Gittos", 16);
        placeAndScorePasta.put("Pastaria", 14);
        placeAndScorePasta.put("Randolfi's", 20);
        placeAndScorePasta.put("Trattoria Marcella", 22);
        return placeAndScorePasta;
    }






}
