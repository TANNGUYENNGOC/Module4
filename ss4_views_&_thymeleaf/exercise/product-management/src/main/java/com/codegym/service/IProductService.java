package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void saveProduct(Product product);
    Product findById(int id);
    void updateProduct(int id, Product product);
    void removeProduct(int id);
}
