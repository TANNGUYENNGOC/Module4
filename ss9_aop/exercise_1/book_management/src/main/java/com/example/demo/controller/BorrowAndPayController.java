package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BorrowAndPay;
import com.example.demo.service.book.IBookService;
import com.example.demo.service.borrow_and_pay.IBorrowAndPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
        bookService.borrow1(book.getId());
        bookService.borrow2(book.getId());
        int code = (int) (Math.random() * (99999 - 10000) + 10000);
        BorrowAndPay borrowAndPay = new BorrowAndPay(code,book);
        borrowAndPayService.save(borrowAndPay);
        redirectAttributes.addFlashAttribute("mess","mượn thành công");
        redirectAttributes.addFlashAttribute("mess1","mã mượn sách của bạn là: "+code);
        return "redirect:/book/list";
    }

    @GetMapping("/showPay")
    private String showPay(){
        return "borrow_and_pay/pay";
    }

    @PostMapping("/pay")
    private String payBook(@RequestParam(name = "maSach") Integer maSach,RedirectAttributes redirectAttributes){
        List<BorrowAndPay> borrowAndPayList = borrowAndPayService.BORROW_AND_PAY_LIST();
        for (int i = 0; i < borrowAndPayList.size() ; i++) {
            if (borrowAndPayList.get(i).getCode()==maSach){
                borrowAndPayList.get(i).getBook().setSachHienCo(borrowAndPayList.get(i).getBook().getSachHienCo()+1);
                borrowAndPayList.get(i).getBook().setSachDaMuon(borrowAndPayList.get(i).getBook().getSachDaMuon()-1);
                borrowAndPayService.remove(borrowAndPayList.get(i).getId());
            }
        }
        redirectAttributes.addFlashAttribute("mess","trả thành công");
        return "redirect:/book/list";
    }
}
