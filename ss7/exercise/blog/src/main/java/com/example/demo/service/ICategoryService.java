package com.example.demo.service;


import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category> {
    List<Category> findAll();
}
