package com.example.demo.service.book;

import com.example.demo.model.Book;
import com.example.demo.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository bookRepository;
    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void borrow1(int id) {
        bookRepository.borrow1(id);
    }

    @Override
    public void borrow2(int id) {
        bookRepository.borrow2(id);
    }

    @Override
    public void pay1(int id) {
        bookRepository.pay1(id);
    }

    @Override
    public void pay2(int id) {
        bookRepository.pay2(id);
    }

    @Override
    public void removeRecord(int code) {
        bookRepository.removeRecord(code);
    }


}
