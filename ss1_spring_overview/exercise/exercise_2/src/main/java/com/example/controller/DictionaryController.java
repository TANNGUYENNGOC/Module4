package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("")
    public String dictionary() {
        return "/index";
    }

    @PostMapping("/dictionary")
    public String dictionary(String inputSearch, Model model) {
        String result = dictionaryService.searchDictionary(inputSearch);
        model.addAttribute("result", result);
        return "/index";
    }
}
