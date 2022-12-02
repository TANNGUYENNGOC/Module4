package com.example.demo.service.book;

import com.example.demo.model.Book;
import com.example.demo.service.IGeneralService;
import org.springframework.data.repository.query.Param;

public interface IBookService extends IGeneralService<Book> {

    void borrow1(@Param("id") int id);
    void borrow2(@Param("id") int id);

    void pay1(@Param("id") int id);
    void pay2(@Param("id") int id);

    void removeRecord(@Param("code") int code);
}
