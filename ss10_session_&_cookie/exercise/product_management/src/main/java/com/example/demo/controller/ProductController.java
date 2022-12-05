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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public CartDto cartDto() {
        return new CartDto();
    }

    //    @GetMapping("")
//    private String showListProduct(Model model, Pageable pageable){
//        model.addAttribute("listProduct",productService.findAll(pageable));
//        return "shop/list";
//    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") long id, HttpServletResponse response, Model model) {
        model.addAttribute("detailProduct", productService.findById(id).get());
        Cookie cookie = new Cookie("idProduct", String.valueOf(id));// ??
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);//??
        return "shop/detail";
    }

    @GetMapping("")
    public String showListProduct(Model model, Pageable pageable, @CookieValue(value = "idProduct", defaultValue = "-1") Long id) {
//        model.addAttribute("listProduct",productService.findAll(pageable));
        if (id != -1) {
            model.addAttribute("historyProduct", productService.findById(id).get());
        }
        model.addAttribute("listProduct", productService.findAll(pageable));

        return "shop/list";
    }

    //Cộng sản phẩm trong cart
    @GetMapping("/add/{id}")
    public String showListCartCount(@PathVariable("id") long id, @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(), productDto);
        cartDto.addProduct(productDto);
        return "redirect:/cart";
    }

    // Trừ sản phẩm trong cart
    @GetMapping("/remove/{id}")
    public String showListCartSubtraction(@PathVariable("id") long id, @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(), productDto);
        cartDto.removeProduct(productDto);
        return "redirect:/cart";
    }
}
