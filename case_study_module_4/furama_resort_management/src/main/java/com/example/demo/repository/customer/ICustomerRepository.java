package com.example.demo.repository.customer;

import com.example.demo.dto.attach_facility.IAttachFacilityCustomer;
import com.example.demo.dto.attach_facility.IAttachFacilityDTO;
import com.example.demo.dto.customer.CustomerDTO1;
import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT c.id, ct.name as typeCustomerName, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c  JOIN customer_type ct ON c.customer_type_id = ct.id where c.flag = 0"
            , countQuery = "SELECT c.id, ct.name as typeCustomerName, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c  JOIN customer_type ct ON c.customer_type_id = ct.id where c.flag = 0"
            , nativeQuery = true)
    Page<CustomerDTO1> listCustomerDto(Pageable pageable);

    @Query(value = "SELECT c.id, ct.name as typeCustomerName, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c JOIN customer_type ct ON c.customer_type_id = ct.id WHERE c.name like CONCAT('%', :name,'%') AND c.email like CONCAT('%', :email,'%') AND ct.name like CONCAT('%', :customerTypeName,'%')"
            , countQuery = "select * from (SELECT c.id, ct.name as typeCustomerName, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c JOIN customer_type ct ON c.customer_type_id = ct.id WHERE c.name like CONCAT('%', :name,'%') AND c.email like CONCAT('%', :email,'%') AND ct.name like CONCAT('%', :customerTypeName,'%'))abc"
            , nativeQuery = true)
    Page<CustomerDTO1> listSearch(Pageable pageable, @Param("name") String name, @Param("email") String email, @Param("customerTypeName") String customerTypeName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customer SET flag = 1 WHERE id = :id",nativeQuery = true)
    void removeFlagCustomer(@Param("id") int id);


    @Query(value = "SELECT  c.flag,c.id, ct.name as typeCustomerName, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c  JOIN customer_type ct ON c.customer_type_id = ct.id join contract c2 on c.id = c2.customer_id where c.flag=0 group by c.id"
            , countQuery = "select * from(SELECT  c.flag,c.id, ct.name as typeCustomerName, c.name, c.date_of_birth as dateOfBirth, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address FROM customer c  JOIN customer_type ct ON c.customer_type_id = ct.id join contract c2 on c.id = c2.customer_id where c.flag=0 group by c.id)abc"
            , nativeQuery = true)
    Page<CustomerDTO1> listCustomerJoinContract(Pageable pageable);

    @Query(value = "select attach_facility.name,attach_facility.cost,attach_facility.unit,attach_facility.status  from attach_facility join contract_detail cd on attach_facility.id = cd.attach_facility_id join contract c on cd.contract_id = c.id join customer c2 on c.customer_id = c2.id where c2.id=:id"
            , countQuery = "select * from(select attach_facility.name,attach_facility.cost,attach_facility.unit,attach_facility.status  from attach_facility join contract_detail cd on attach_facility.id = cd.attach_facility_id join contract c on cd.contract_id = c.id join customer c2 on c.customer_id = c2.id where c2.id=:id)abc"
            , nativeQuery = true)
    Page<IAttachFacilityCustomer> listAttachFacility(@Param("id") int id, Pageable pageable);

}
