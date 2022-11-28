package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/category-list")
    private String listCategory(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "category/list";
    }

    @GetMapping("/create")
    private String showFormAddCategory(Model model){
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    private  String addCategory(@ModelAttribute("category") Category category,RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/category/category-list";
    }

    @GetMapping("/{id}/remove")
    private String showFormDeleteCategory(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "category/delete";
    }
    @PostMapping("/category-delete")
    private String deleteCategory(Category category,RedirectAttributes redirectAttributes){
        categoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/category/category-list";
    }
    @GetMapping("/{id}/update")
    private String showFormUpdateCategory(@PathVariable Long id, Model model){
        model.addAttribute("categogy",categoryService.findById(id));
        return "category/update";
    }

    @PostMapping("/category-update")
    private String updateCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        return "redirect:/category/category-list";
    }

}
