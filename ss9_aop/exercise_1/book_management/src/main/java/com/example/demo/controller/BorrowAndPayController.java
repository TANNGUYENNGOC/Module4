package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.book.IBookService;
import com.example.demo.service.borrow_and_pay.IBorrowAndPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrowAndPay")
public class BorrowAndPayController {
    @Autowired
    IBorrowAndPayService borrowAndPayService;
    @Autowired
    IBookService bookService;

    @GetMapping("/{id}/borrow")
    private String showFormBorrow(@ModelAttribute("book")Book book, Model model){
        model.addAttribute("book",bookService.findById(book.getId()));
        return "borrow_and_pay/borrow";
    }

    @PostMapping("/borrow")
    private String borrowBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes){
        borrowAndPayService.borrow(book.getId());
        redirectAttributes.addFlashAttribute("mess","mượn thành công");
        return "redirect: /book/list";
    }
}
