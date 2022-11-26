package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("")
    private String showList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "product/list";
    }
    // TỚi trang thêm mới
    @GetMapping("/add")
    private String add(Model model){
        model.addAttribute("product", new Product());
        return "product/add";
    }
    // Xử lí thêm mới
    @PostMapping("/add")
    private String addProduct( Product product){
        productService.saveProduct(product);
        return "product/list";
    }
    //Tới trang update
    @GetMapping("/{id}/update")
    private String showFormUpdate(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/update";
    }
    //Xử lí update
    @PostMapping("/update")
    private String updateProduct(Product product){
        productService.updateProduct(product);
        return "product/list";
    }

    //Tới trang xem để xóa
    @GetMapping("/{id}/remove")
    private String showFormRemove(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/remove";
    }
    //Xử lí xóa
    @PostMapping("/remove")
    private String removeProduct(Product product){
        productService.removeProduct(product.getId());
        return "product/list";
    }

    //Tới trang xem chi tiết sản phẩm
    @GetMapping("/{id}/see_details")
    private String seeDetails(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/see_details";
    }

    // kết quả search
    @PostMapping("search")
    private String search(@RequestParam String search, Model model){
        List<Product> productList = productService.searchName(search);
        model.addAttribute("productList",productList);
        return "product/list";
    }

}
