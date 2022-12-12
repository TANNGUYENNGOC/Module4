package com.example.demo.service;

import com.example.demo.dto.attach_facility.IAttachFacilityDTO;
import com.example.demo.dto.contract.ContractDTO1;
import com.example.demo.model.contract.Contract;
import com.example.demo.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IContractService extends IGeneralService<Contract> {
    Page<ContractDTO1> listContract(Pageable pageable);
    Page<IAttachFacilityDTO> listAttachFacility(int id, Pageable pageable);
}
