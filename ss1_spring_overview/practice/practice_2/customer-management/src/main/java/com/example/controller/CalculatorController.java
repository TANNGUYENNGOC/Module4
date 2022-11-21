package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("")
    public String calculator() {
        return "/index";
    }

    @PostMapping("/calculator")
//    public String division(double a, double b, String math, Model model) {
    public String division(@RequestParam("a") int a,
                           @RequestParam("b") int b,
                           @RequestParam("math") String math,
                           Model model) {
        double result = calculatorService.calculator(a, b, math);
        model.addAttribute("result",result);
        return "/index";
    }

}
