package org.launchcode.BeSTL.models;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Created by estel on 7/17/2017.
 */
@Entity
public class Category extends AbstractEntity {

    @NotNull
    @Size(min = 3, max = 15, message = "Name must be between 3 and 15 characters.")
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Restaurant> restaurants = new ArrayList<>();

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public List getRests(){
        return restaurants;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}