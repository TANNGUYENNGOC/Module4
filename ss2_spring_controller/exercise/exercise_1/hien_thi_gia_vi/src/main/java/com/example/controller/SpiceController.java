package com.example.controller;

import com.example.service.ISpiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpiceController {
    @Autowired
    private ISpiceService spiceService;

    @GetMapping("")
    public String spice() {
        return "/index";
    }

    @PostMapping("/spice")
    public String spiceList(@RequestParam(value = "Lettuce",required = false) String lettuce,
                            @RequestParam(value = "Tomato",required = false) String tomato,
                            @RequestParam(value = "Mastard",required = false) String mastard,
                            @RequestParam(value = "Sprouts",required = false) String sprouts,
                            Model model) {
        List<String>list = spiceService.showSpiceList(lettuce,tomato,mastard,sprouts);
        model.addAttribute("list", list);
        return "/index";
    }
}
