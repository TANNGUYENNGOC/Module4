package com.example.demo.controller;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.service.IProducService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProducService producService;

    @GetMapping("/product-list")
    public String showList(Model model, Pageable pageable,@CookieValue(value = "idProduct",defaultValue = "-1") Long id){
        model.addAttribute("listProduct",producService.findAll(pageable));
        if(id != -1) {
            model.addAttribute("productCookie", producService.findById(id).get());
        }
        return "shop/list";
    }

    @GetMapping("/show-detail/{id}")
    public String showDetailProduct(Model model, @PathVariable("id") Long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct",String.valueOf(id));
        cookie.setMaxAge(15);
//        cookie.setPath("/product/product-list"); có thể làm cụ thể như lày
        cookie.setPath("/");
        response.addCookie(cookie);
        Product product = producService.findById(id).get();
        model.addAttribute("product",product);
        return "shop/detail";
    }

    @ModelAttribute("cart")
    public CartDto khoiTaoCart(){
        return new CartDto();
    }
    @GetMapping("/themSanPham")
    public String themVaoGioHang(@PathVariable("id") Long id,
                                 RedirectAttributes redirectAttributes,
                                 @SessionAttribute("cart") CartDto cartDto,
                                 @RequestParam("action") String action){
        Optional<Product> product = producService.findById(id);
        if(!product.isPresent()){
            return "eror";
        }
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(),productDto);
        if(action.equals("cart")){
            cartDto.congProduct(productDto);
            return "redirect:/cart";
        }else {
            cartDto.congProduct(productDto);
            return "redirect:/product/product-list";
        }
    }
}
