package com.example.demo.service;


import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Optional<Product> findById(Long id);
}
