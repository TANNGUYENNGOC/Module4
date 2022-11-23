package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private  IProductService productService = new ProductServiceImpl();
    @GetMapping("")
    private String showList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "product/list";
    }
    // TỚi trang thêm mới
    @GetMapping("/product/add")
    private String add(Model model){
        model.addAttribute("product", new Product());
        return "product/add";
    }
    // Xử lí thêm mới
    @PostMapping("/product/add")
    private String addProduct( Product product){
        productService.saveProduct(product);
        return "product/list";
    }
    //Tới trang update
    @GetMapping("/product/{id}/update")
    private String showFormUpdate(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/update";
    }
    //Xử lí update
    @PostMapping("/product/update")
    private String updateProduct(Product product){
        productService.updateProduct(product.getId(),product);
        return "product/list";
    }

    //Tới trang xem để xóa
    @GetMapping("/product/{id}/remove")
    private String showFormRemove(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/remove";
    }
    //Xử lí xóa
    @PostMapping("/product/remove")
    private String removeProduct(Product product){
        productService.removeProduct(product.getId());
        return "product/list";
    }

    //Tới trang xem chi tiết sản phẩm
    @GetMapping("/product/{id}/see_details")
    private String seeDetails(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/see_details";
    }


}
