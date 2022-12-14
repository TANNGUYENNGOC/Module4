package com.example.demo.service.impl;

import com.example.demo.dto.attach_facility.IAttachFacilityCustomer;
import com.example.demo.dto.attach_facility.IAttachFacilityDTO;
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
        return customerRepository.listCustomerDto(pageable);
    }

    @Override
    public Page<CustomerDTO1> listSearch(Pageable pageable, String name, String email, String customerTypeName) {
        return customerRepository.listSearch(pageable ,name,email,customerTypeName);
    }

    @Override
    public void removeFlagCustomer(int id) {
        customerRepository.removeFlagCustomer(id    );
    }

    @Override
    public Page<CustomerDTO1> listCustomerJoinContract(Pageable pageable) {
        return customerRepository.listCustomerJoinContract(pageable);
    }

    @Override
    public Page<IAttachFacilityCustomer> listAttachFacility(int id, Pageable pageable) {
        return customerRepository.listAttachFacility(id,pageable);
    }
}
