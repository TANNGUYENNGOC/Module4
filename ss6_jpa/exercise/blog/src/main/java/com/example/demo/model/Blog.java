package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String author;

    @Column(columnDefinition = "DATETIME")
    private String dateOfWriting;

    public Blog() {
    }

    public Blog(Long id, String title, String content, String author, String dateOfWriting) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateOfWriting = dateOfWriting;
    }

    public Blog(String title, String content, String author, String dateOfWriting) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateOfWriting = dateOfWriting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(String dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }
}
