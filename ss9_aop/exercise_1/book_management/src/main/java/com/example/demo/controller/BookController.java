package com.example.demo.controller;

import com.example.demo.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping("/list")
    private String showList(@PageableDefault(page = 0, size = 3) Pageable pageable, Model model) {
        model.addAttribute("listBook", bookService.findAll(pageable));
        return "book/list";
    }

}
