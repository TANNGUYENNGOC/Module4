package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;
    @GetMapping("")
    private String showList(Model model, @PageableDefault(page = 1,size = 3)Pageable pageable){
        Page<Blog> blogList =  blogService.findAll(pageable);
        model.addAttribute("blogList",blogList);
        return "blog/list";
    }

    @GetMapping("/create")
    private String add(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    private String addProduct(@ModelAttribute("blog") Blog blog,RedirectAttributes redirectAttributes){
            blogService.save(blog);
            redirectAttributes.addFlashAttribute("mess","thêm mới thành công");
        return "redirect:/blog/";
    }

    @GetMapping("/update")
    private String showFormUpdate(@RequestParam Long id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("categoryList",categoryService.findAll());
        return "blog/update";
    }

    @PostMapping("/update")
    private String updateBlog(@RequestParam("id") Long id ,
                              @RequestParam("title") String name,
                              @RequestParam String content,
                              @RequestParam String author,
                              @RequestParam String dateOfWriting,
                              @RequestParam Category category,
                              RedirectAttributes redirectAttributes){
        Blog blog = new Blog(id,name,content,author,dateOfWriting,category);
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        return "redirect:/blog/";
    }

    @GetMapping("/{id}/remove")
    private String showFormDelete(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog/delete";
    }
    @PostMapping("/delete")
    private String deleteBlog(Blog blog, RedirectAttributes redirectAttributes){
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/blog/";
    }
}
