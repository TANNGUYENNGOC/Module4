package com.example.demo.repository;

import com.example.demo.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
    List<CustomerType> findAll();
}
