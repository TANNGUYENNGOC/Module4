package com.example.demo.model;

import javax.persistence.*;

@Entity
public class BorrowAndPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Book book;

    public BorrowAndPay() {
    }

    public BorrowAndPay( Book book, String code) {

        this.book = book;
    }

    public BorrowAndPay(int id, Book book) {
        this.id = id;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
