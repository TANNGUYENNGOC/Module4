package com.example.demo.service.impl;

import com.example.demo.model.contract.ContractDetail;
import com.example.demo.repository.contract_detail.IContractDetailRepository;
import com.example.demo.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;
    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public Optional<ContractDetail> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(ContractDetail contractDetail) {

    }

    @Override
    public void remove(Integer id) {

    }
}
