package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.BorrowAndPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IBorrowAndPayRepository extends JpaRepository<Book,Integer> {
    @Transactional
    @Modifying
    @Query(value="update book set amount = amount-1 where id = :id", nativeQuery = true)
    void borrow(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value="update book set amount = amount+1 where id = :id", nativeQuery = true)
    void pay(@Param("id") int id);
}
