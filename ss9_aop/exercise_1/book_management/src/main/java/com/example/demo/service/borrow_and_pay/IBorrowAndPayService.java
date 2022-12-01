package com.example.demo.service.borrow_and_pay;

import com.example.demo.model.Book;

import com.example.demo.service.IGeneralService;
import org.springframework.data.repository.query.Param;

public interface IBorrowAndPayService extends IGeneralService<Book> {
    void borrow(@Param("id") int id);
    void pay(@Param("id") int id);
}
