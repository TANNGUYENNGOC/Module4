package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("")
public class GreetingController {
    @RequestMapping("")
//    public String greeting(@RequestParam String name, Model model){
    public String greeting(){
//        model.addAttribute("name", name);
        return "index";

    }
}
