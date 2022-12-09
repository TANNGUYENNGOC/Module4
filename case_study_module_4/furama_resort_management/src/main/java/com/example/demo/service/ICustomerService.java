package com.example.demo.service;

import com.example.demo.dto.CustomerDTO1;
import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService extends IGeneralService<Customer>{
    Page<CustomerDTO1> listCustomerDto (Pageable pageable);
    Page<CustomerDTO1> listSearch (Pageable pageable, String name, String email, String customerTypeName);

}
