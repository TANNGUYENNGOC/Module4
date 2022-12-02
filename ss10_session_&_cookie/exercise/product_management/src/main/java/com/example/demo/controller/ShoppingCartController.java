package com.example.demo.controller;


import com.example.demo.dto.CartDto;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/shop")
@SessionAttributes("cart")
public class ShoppingCartController {
    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }

    @Autowired
    private IProductService iProductService;

    @GetMapping
    public ModelAndView showListPage(Model model, @CookieValue(value = "iProduct"),d)

}
