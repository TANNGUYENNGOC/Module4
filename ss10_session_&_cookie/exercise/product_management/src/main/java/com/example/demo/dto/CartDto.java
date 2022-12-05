package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        /*== containsKey: so sánh key ==*/
        /*== productMap.get(key) = lấy ra value ==*/
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public void removeProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            /*== productMap.get(key) = lấy ra value*/
            Integer currentValue = productMap.get(productDto);
            if (currentValue > 1) {
                productMap.replace(productDto, currentValue - 1);
            } else {
                productMap.remove(productDto);
            }
        }
    }


    public void pay() {
        productMap.clear();
    }

    //lấy ra số lượng phần tử trong map
    public Integer countItemQuantity() {
        return productMap.size();
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            productQuantity = productQuantity + entry.getValue();
        }
        return productQuantity;
    }

    public Float countTotalPayment() {
        Float total = 0F;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            total = total + entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void payProduct() {
        productMap.clear();
    }
}
