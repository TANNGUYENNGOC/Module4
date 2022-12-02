package com.example.demo.service.borrow_and_pay;

import com.example.demo.model.Book;

import com.example.demo.model.BorrowAndPay;
import com.example.demo.service.IGeneralService;

import java.util.List;

public interface IBorrowAndPayService extends IGeneralService<BorrowAndPay> {
    List<BorrowAndPay> BORROW_AND_PAY_LIST();

}
