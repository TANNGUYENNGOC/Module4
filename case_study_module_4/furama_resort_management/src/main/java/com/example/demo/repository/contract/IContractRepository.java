package com.example.demo.repository.contract;

import com.example.demo.dto.attach_facility.IAttachFacilityDTO;
import com.example.demo.dto.contract.ContractDTO1;
import com.example.demo.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "SELECT contract.id, facility.name as nameFacility, employee.name as nameEmployee, customer.name as nameCustomer,  contract.start_date as startDate, contract.end_date as endDate, contract.deposit,ifnull(facility.cost,0)+sum(ifnull(contract_detail.quantity*attach_facility.cost,0)) AS sumMoney FROM contract left JOIN contract_detail ON contract.id = contract_detail.contract_id left JOIN attach_facility ON attach_facility.id = contract_detail.attach_facility_id left JOIN facility ON facility.id = contract.facility_id left JOIN customer ON customer.id = contract.customer_id JOIN employee ON employee.id = contract.employee_id GROUP BY contract.id"
            ,countQuery="   SELECT contract.id, facility.name as nameFacility, employee.name as nameEmployee, customer.name as nameCustomer,  contract.start_date as startDate, contract.end_date as endDate, contract.deposit,ifnull(facility.cost,0)+sum(ifnull(contract_detail.quantity*attach_facility.cost,0)) AS sumMoney FROM contract left JOIN contract_detail ON contract.id = contract_detail.contract_id left JOIN attach_facility ON attach_facility.id = contract_detail.attach_facility_id left JOIN facility ON facility.id = contract.facility_id left JOIN customer ON customer.id = contract.customer_id JOIN employee ON employee.id = contract.employee_id GROUP BY contract.id"
            ,nativeQuery = true)
    Page<ContractDTO1> listContract(Pageable pageable);

    @Query(value = "SELECT contract.id as contractId,attach_facility.name,attach_facility.cost,attach_facility.unit,attach_facility.status,contract_detail.quantity,(attach_facility.cost*contract_detail.quantity) as sumAttach FROM contract JOIN contract_detail ON contract.id = contract_detail.contract_id JOIN attach_facility ON attach_facility.id = contract_detail.attach_facility_id WHERE contract.id = :id"
            ,countQuery="SELECT contract.id as contractId,attach_facility.name,attach_facility.cost,attach_facility.unit,attach_facility.status,contract_detail.quantity,(attach_facility.cost*contract_detail.quantity) as sumAttach FROM contract JOIN contract_detail ON contract.id = contract_detail.contract_id JOIN attach_facility ON attach_facility.id = contract_detail.attach_facility_id WHERE contract.id = :id"
            ,nativeQuery = true)
    Page<IAttachFacilityDTO> listAttachFacility(@Param("id") int id, Pageable pageable);

}
