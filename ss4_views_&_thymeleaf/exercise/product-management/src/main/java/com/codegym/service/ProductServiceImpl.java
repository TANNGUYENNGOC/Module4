package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService{
    private static final Map<Integer,Product> productList = new HashMap<>();
    static {
        productList.put(2,new Product(2,"Exciter",34,"Yamaha"));
        productList.put(4,new Product(4,"Exciter",34,"Yamaha"));
        productList.put(1,new Product(1,"Exciter",34,"Yamaha"));
        productList.put(7,new Product(7,"Exciter",34,"Yamaha"));
        productList.put(3,new Product(3,"Exciter",34,"Yamaha"));
        productList.put(9,new Product(9,"Exciter",34,"Yamaha"));
    }
    @Override
    public List<Product> findAll() {
        return new  ArrayList<>(productList.values());
    }

    @Override
    public void saveProduct(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public void removeProduct(int id) {
        productList.remove(id);
    }
}
