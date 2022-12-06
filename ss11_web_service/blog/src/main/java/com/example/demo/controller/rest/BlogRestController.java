package com.example.demo.controller.rest;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-blog")
public class BlogRestController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> getList(Pageable pageable) {
        Page<Blog> blogList = blogService.findAll(pageable);
//        if (blogList.getSize()==0) {
        if (blogList.isEmpty()) {
            //NO_CONTENT trạng thái không tìm thấy của list
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Blog>> getBlogByCategory(@PathVariable("category") Category category) {
        List<Blog> categoryList = blogService.findByCategory(category);
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/detail/{blog}")
    public ResponseEntity<Blog> getBlogDetail(@PathVariable("blog") Long id) {
        Blog blog = blogService.findById(id).get();
        if (blog == null) {
            //NO_CONTENT trạng thái không tìm thấy của object
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    //thêm mới blog
    @PostMapping(path = "")
    public ResponseEntity create(@RequestBody Blog blog) {
        blog.setCategory(categoryService.findById(blog.getCategory().getId()).get());
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Xóa Blog
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") Long id) {
        Blog blog = blogService.findById(id).get();
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Chỉnh sửa blog
    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> update(@PathVariable("id") Long id, @RequestBody Blog blog) {
        Blog blog1 = blogService.findById(id).get();
        if (blog1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
