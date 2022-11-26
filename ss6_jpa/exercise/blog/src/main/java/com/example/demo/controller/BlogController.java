package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("/")
    private String showList(Model model){
        List<Blog> blogList = (List<Blog>) blogService.findAll();
        model.addAttribute("blogList",blogList);
        return "blog/list";
    }

    @GetMapping("/create-blog")
    private String add(Model model){
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/create-blog")
    private String addProduct(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "blog/list";
    }

    @GetMapping("/{id}/update")
    private String showFormUpdate(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog/update";
    }

    @PostMapping("update-blog")
    private String updateBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "blog/list";
    }

    @GetMapping("/{id}/remove")
    private String showFormDelete(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog/delete";
    }
    @PostMapping("/delete-blog")
    private String deleteBlog(Blog blog){
        blogService.remove(blog.getId());
        return "";
    }
}
