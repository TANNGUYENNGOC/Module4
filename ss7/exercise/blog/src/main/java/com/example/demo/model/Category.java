package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String stringCategory;

    public Category(Long id, String stringCategory) {
        this.id = id;
        this.stringCategory = stringCategory;
    }

    public Category(Long id) {
        this.id = id;
    }

    public Category(String stringCategory) {
        this.stringCategory = stringCategory;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringCategory() {
        return stringCategory;
    }

    public void setStringCategory(String stringCategory) {
        this.stringCategory = stringCategory;
    }
}
