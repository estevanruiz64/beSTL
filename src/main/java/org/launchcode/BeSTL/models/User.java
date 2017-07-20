package org.launchcode.BeSTL.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by estel on 7/20/2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15, message="Username must be between 3 and 15 characters.")
    private String username;

    @NotNull
    @Size(min=6, max=30, message="Email must be between 6 and 30 characters.")
    private String email;

    @NotNull
    @Size(min=6, max=30, message="Password must be between 6 and 30 characters.")
    private String password;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Vote> votes = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
