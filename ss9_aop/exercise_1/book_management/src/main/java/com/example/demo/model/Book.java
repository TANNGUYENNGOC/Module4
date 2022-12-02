package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String nameBook;

    private int amount;
    private int sachHienCo;
    private int sachDaMuon;

    public Book() {
    }

    public Book(int id, String nameBook, int amount, int sachHienCo, int sachDaMuon) {
        this.id = id;
        this.nameBook = nameBook;
        this.amount = amount;
        this.sachHienCo = sachHienCo;
        this.sachDaMuon = sachDaMuon;
    }

    public Book(String nameBook, int amount, int sachHienCo, int sachDaMuon) {
        this.nameBook = nameBook;
        this.amount = amount;
        this.sachHienCo = sachHienCo;
        this.sachDaMuon = sachDaMuon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSachHienCo() {
        return sachHienCo;
    }

    public void setSachHienCo(int sachHienCo) {
        this.sachHienCo = sachHienCo;
    }

    public int getSachDaMuon() {
        return sachDaMuon;
    }

    public void setSachDaMuon(int sachDaMuon) {
        this.sachDaMuon = sachDaMuon;
    }
}
