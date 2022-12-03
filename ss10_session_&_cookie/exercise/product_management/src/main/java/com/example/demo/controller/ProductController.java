package com.example.demo.controller;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    private CartDto cartDto (){
        return new CartDto();
    }

    @GetMapping("")
    private String showListProduct(Model model, Pageable pageable){
        model.addAttribute("listProduct",productService.findAll(pageable));
        return "shop/list";
    }

    //Cộng sản phẩm trong cart
    @GetMapping("/add/{id}")
    private String showListCartCount(@PathVariable("id") long id,@SessionAttribute("cart") CartDto cartDto){
        Optional<Product> product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(),productDto);
        cartDto.addProduct(productDto);
        return "redirect:/cart";
    }

    // Trừ sản phẩm trong cart
    @GetMapping("/remove/{id}")
    private String showListCartSubtraction(@PathVariable("id") long id,@SessionAttribute("cart") CartDto cartDto){
        Optional<Product> product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(),productDto);
        cartDto.removeProduct(productDto);
        return "redirect:/cart";
    }
}
