package com.example.demo.dto;

import com.example.demo.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productDtoMap = new HashMap<>();

    public CartDto() {
    }

    public void setProductDtoMap(Map<ProductDto, Integer> productDtoMap) {
        this.productDtoMap = productDtoMap;
    }

    public Map<ProductDto, Integer> getProductDtoMap() {
        return productDtoMap;
    }

    public void congProduct(ProductDto productDto) {
        if (productDtoMap.containsKey(productDto)) {
            int value = productDtoMap.get(productDto);
            productDtoMap.replace(productDto, value + 1);
        } else {
            productDtoMap.put(productDto, 1);
        }
    }

    public void truProduct(ProductDto productDto) {
        if (productDtoMap.containsKey(productDto)) {
            int value = productDtoMap.get(productDto);
            if (value > 1) {
                productDtoMap.replace(productDto, value - 1);
            } else {
                productDtoMap.remove(productDto);
            }
        }
    }
    public int tongKey(){
        return productDtoMap.size();
    }
    public int tongValue(){
        int soLuong = 0;
        for (Map.Entry<ProductDto,Integer> entry: productDtoMap.entrySet()){
            soLuong= soLuong+entry.getValue();
        }
        return soLuong;
    }

    public Float tongThanhToan(){
        float tien = 0;
        for (Map.Entry<ProductDto,Integer> entry: productDtoMap.entrySet()){
            tien= tien+entry.getValue()*entry.getKey().getPrice();
        }
        return tien;
    }
}
