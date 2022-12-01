package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String username;
    private String passworld;

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
