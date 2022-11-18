package com.example.controller;

import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConvertController {
    @Autowired
    IConvertService convertService;

    @GetMapping("")
    public String convert(){
        return  "/index";
    }

    @PostMapping("/convert_to_vnd")
    public String convertToVND(double input, Model model){
        double result = convertService.convertVND(input);
        model.addAttribute("result",result+"VND");
        return "/index";
    }

}
