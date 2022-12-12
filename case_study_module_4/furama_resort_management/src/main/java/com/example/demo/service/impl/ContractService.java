package com.example.demo.service.impl;

import com.example.demo.dto.attach_facility.IAttachFacilityDTO;
import com.example.demo.dto.contract.ContractDTO1;
import com.example.demo.model.contract.Contract;
import com.example.demo.model.facility.Facility;
import com.example.demo.repository.contract.IContractRepository;
import com.example.demo.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<ContractDTO1> listContract(Pageable pageable) {
        return contractRepository.listContract(pageable);
    }

    @Override
    public Page<IAttachFacilityDTO> listAttachFacility(int id, Pageable pageable) {
        return contractRepository.listAttachFacility(id,pageable);
    }
}
