package com.example.demo.service.impl;

import com.example.demo.dto.customer.CustomerDTO1;
import com.example.demo.model.customer.Customer;
import com.example.demo.repository.customer.ICustomerRepository;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }


    @Override
    public Page<CustomerDTO1> listCustomerDto(Pageable pageable) {
        Page<CustomerDTO1> listCustomerDto = customerRepository.listCustomerDto(pageable);
        CustomerDTO1  customerDTO1 = listCustomerDto.getContent().get(0);
        System.out.println("-----------------------------------------------------------------");
        System.out.println(customerDTO1.getTypeCustomerName());
        return listCustomerDto;
    }

    @Override
    public Page<CustomerDTO1> listSearch(Pageable pageable, String name, String email, String customerTypeName) {
        return customerRepository.listSearch(pageable   ,name,email,customerTypeName);
    }
}
