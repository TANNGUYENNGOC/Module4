package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void saveProduct(Product product);
    Product findById(int id);
    void updateProduct(Product product);
    void removeProduct(int id);
    List<Product> searchName(String nameProduct);
}
