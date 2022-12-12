package com.example.demo.service.impl;

import com.example.demo.model.customer.CustomerType;
import com.example.demo.repository.customer.ICustomerTypeRepository;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return customerTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<CustomerType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
