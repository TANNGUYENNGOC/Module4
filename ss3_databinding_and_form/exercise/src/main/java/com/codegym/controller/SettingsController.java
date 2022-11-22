package com.codegym.controller;

import com.codegym.model.Settings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class SettingsController {
    @GetMapping("")
    public String showForm(ModelMap model){
        List<String> languageList = Arrays.asList("English","Vietnamese","Japanese","Chinese");
        model.addAttribute("languageList",languageList);

        List<Integer> pageSizeList = Arrays.asList(5,10,15,25,50,100);
        model.addAttribute("pageSizeList",pageSizeList);

        model.addAttribute("settings", new Settings());
        return "/index";
    }

    @PostMapping("settings")
    public String submit(@ModelAttribute("settings") Settings settings, ModelMap model){
        model.addAttribute("languages",settings.getLanguages());
        model.addAttribute("pageSize",settings.getPageSize());
        model.addAttribute("spamsFilter",settings.isSpamsFilter());
        model.addAttribute("signature",settings.getSignature());
        return "/display";
    }
}
