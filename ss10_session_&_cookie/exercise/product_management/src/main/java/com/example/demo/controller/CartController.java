package com.example.demo.controller;

import com.example.demo.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("")
    public String showCart(@SessionAttribute("cart")CartDto cartDto, Model model){
        model.addAttribute("cartDto",cartDto);
        return "cart/list";
    }

    @GetMapping("/pay")
    public String payProduct(@SessionAttribute("cart")CartDto cartDto, RedirectAttributes redirectAttributes){
        cartDto.payProduct();
        redirectAttributes.addFlashAttribute("mess","Thanh toán thành công ");
        return "redirect:/shop";
    }
}
