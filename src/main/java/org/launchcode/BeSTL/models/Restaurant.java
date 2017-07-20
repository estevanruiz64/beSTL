package org.launchcode.BeSTL.models;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by estel on 7/15/2017.
 */
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Vote> votes = new ArrayList<>();

    private int score = votes.size();

    @ManyToOne
    private Category category;

    public Restaurant(){}

    public Restaurant(String name){
        this.name = name;
    }






    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }
}
