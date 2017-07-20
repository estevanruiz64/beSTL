package org.launchcode.BeSTL.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by estel on 7/20/2017.
 */
@Entity
public class Vote {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private User user;


    //getters and setters
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
