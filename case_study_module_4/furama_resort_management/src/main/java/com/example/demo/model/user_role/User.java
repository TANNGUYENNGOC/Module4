package com.example.demo.model.user_role;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class User {
    @Id
    private String username;
    private String passworld;
    @ManyToMany
    private Set<Role> roleId;
    public User() {
    }

    public User(String username, String passWorld) {
        this.username = username;
        this.passworld = passWorld;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWorld() {
        return passworld;
    }

    public void setPassWorld(String passWorld) {
        this.passworld = passWorld;
    }
}
