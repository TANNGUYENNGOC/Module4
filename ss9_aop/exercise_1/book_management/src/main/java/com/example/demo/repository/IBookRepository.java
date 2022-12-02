package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update book set sach_hien_co = sach_hien_co - 1 where id =:id", nativeQuery = true)
    void borrow1(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update book set sach_da_muon = sach_da_muon + 1 where id =:id", nativeQuery = true)
    void borrow2(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update book set sach_hien_co = sach_hien_co + 1", nativeQuery = true)
    void pay1(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update book set sach_hien_co = sach_hien_co - 1", nativeQuery = true)
    void pay2(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "delete from borrow_and_pay where code = :code", nativeQuery = true)
    void removeRecord(@Param("code") int code);
}
