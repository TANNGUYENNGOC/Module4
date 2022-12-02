package com.example.demo.model;

import javax.persistence.*;

@Entity
public class BorrowAndPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int code;

    @ManyToOne
    private Book book;

    public BorrowAndPay() {
    }

    public BorrowAndPay(Book book) {
        this.book = book;
    }

    public BorrowAndPay(int code, Book book) {
        this.code = code;
        this.book = book;
    }

    public BorrowAndPay(int id, int code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
