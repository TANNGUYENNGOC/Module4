package com.example.demo.service.borrow_and_pay;

import com.example.demo.model.Book;
import com.example.demo.model.BorrowAndPay;
import com.example.demo.repository.IBorrowAndPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowAndPayImpl implements IBorrowAndPayService {
    @Autowired
    IBorrowAndPayRepository borrowAndPayRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return borrowAndPayRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return borrowAndPayRepository.findById(id);
    }

    @Override
    public void save(Book borrowAndPay) {
        borrowAndPayRepository.save(borrowAndPay);
    }

    @Override
    public void remove(Integer id) {
        borrowAndPayRepository.deleteById(id);
    }
    @Override
    public void borrow(int id) {
        borrowAndPayRepository.borrow(id);
    }

    @Override
    public void pay(int id) {
        borrowAndPayRepository.pay(id);
    }
}
