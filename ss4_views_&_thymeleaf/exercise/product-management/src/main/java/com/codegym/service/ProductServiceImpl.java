package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService{
    private static final Map<Integer,Product> productList = new HashMap<>();
    static {
        productList.put(2,new Product(2,"Exciter 150",25,"Yamaha"));
        productList.put(4,new Product(4,"Exciter 155",19,"Yamaha"));
        productList.put(1,new Product(1,"Galaxy note 10",24,"SamSung"));
        productList.put(7,new Product(7,"Sh150",38,"Honda"));
        productList.put(3,new Product(3,"Galaxy not 8",6,"Samsung"));
        productList.put(9,new Product(9,"Exciter 135",15,"Yamaha"));
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

    @Override
    public List<Product> searchName(String nameProduct) {
        List<Product> productList = findAll();
        List<Product>productListSearch = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().contains(nameProduct)){
                productListSearch.add(productList.get(i));
            }
        }

        return productListSearch;
    }
}
