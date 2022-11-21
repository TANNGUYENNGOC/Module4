package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String greeting(){
        return "/greeting";
    }
}
