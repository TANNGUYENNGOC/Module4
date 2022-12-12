package com.example.demo.repository.customer;

import com.example.demo.dto.customer.CustomerDTO1;
import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT c.id, ct.name as typeCustomerName, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c  JOIN customer_type ct ON c.customer_type_id = ct.id"
            ,countQuery="SELECT c.id, ct.name as typeCustomerName, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c  JOIN customer_type ct ON c.customer_type_id = ct.id"
            ,nativeQuery = true)
    Page<CustomerDTO1> listCustomerDto (Pageable pageable);

    @Query(value = "SELECT c.id, ct.name as typeCustomerName, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c JOIN customer_type ct ON c.customer_type_id = ct.id WHERE c.name like CONCAT('%', :name,'%') AND c.email like CONCAT('%', :email,'%') AND ct.name like CONCAT('%', :customerTypeName,'%')"
            ,countQuery = "select * from (SELECT c.id, ct.name as typeCustomerName, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c JOIN customer_type ct ON c.customer_type_id = ct.id WHERE c.name like CONCAT('%', :name,'%') AND c.email like CONCAT('%', :email,'%') AND ct.name like CONCAT('%', :customerTypeName,'%'))abc"
            , nativeQuery = true)
    Page<CustomerDTO1> listSearch (Pageable pageable, @Param("name") String name,@Param("email") String email,@Param("customerTypeName") String customerTypeName);

}
