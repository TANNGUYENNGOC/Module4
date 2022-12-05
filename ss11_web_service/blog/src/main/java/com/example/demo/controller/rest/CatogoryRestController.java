package com.example.demo.controller.rest;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api-category")
public class CatogoryRestController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired

    @GetMapping("")
    public ResponseEntity<List<Category>> getList() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }


    //Phương thức thêm mới thể loại
    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        categoryService.save(category);
        Category category1 = categoryService.findById(category.getId()).get();
        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }

    //Xóa thể loại
    @DeleteMapping("{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id).get();
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    //update thể loại
//    @PutMapping(path = "{id}")
//    public ResponseEntity update(@PathVariable("id") Long id,@RequestBody Category category){
//        category = categoryService.findById(id).get();
//        if ()
//    }

}
