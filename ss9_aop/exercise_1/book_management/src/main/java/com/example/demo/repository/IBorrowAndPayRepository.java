package com.example.demo.repository;


import com.example.demo.model.BorrowAndPay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowAndPayRepository extends JpaRepository<BorrowAndPay,Integer> {

}
