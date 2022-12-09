package com.example.demo.model.customer;

import com.example.demo.model.customer.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    @OneToMany(mappedBy = "customerType",cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Customer> customers;

    public CustomerType(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    public Set<Customer> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(Set<Customer> customers) {
//        this.customers = customers;
//    }

    public CustomerType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
