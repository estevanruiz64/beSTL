package org.launchcode.BeSTL.models;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by estel on 7/15/2017.
 */
@Entity
public class Restaurant extends AbstractEntity{

    @NotNull
    @Size(min=1, message="You didn't enter a name, dumby.")
    private String name;

    @OneToMany
    @JoinColumn(name = "restaurant_uid")
    private List<Vote> votes = new ArrayList<>();

    private int score = votes.size();

    @ManyToOne
    private Category category;

    public Restaurant(){}

    public Restaurant(String name){
        this.name = name;
    }


    public void addVote(Vote vote){
        this.getVotes().add(vote);
        this.score = votes.size();
    }



    //getters and setters
    public List<Vote> getVotes() {
        return votes;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
