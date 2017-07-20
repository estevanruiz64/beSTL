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
}
