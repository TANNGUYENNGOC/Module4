package com.example.demo.service.impl;

import com.example.demo.model.contract.AttachFacility;
import com.example.demo.repository.attach_facility.IAttachFacilityReposotory;
import com.example.demo.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    IAttachFacilityReposotory attachFacilityReposotory;
    @Override
    public Page<AttachFacility> findAll(Pageable pageable) {
        return attachFacilityReposotory.findAll(pageable);
    }

    @Override
    public Optional<AttachFacility> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(AttachFacility attachFacility) {

    }

    @Override
    public void remove(Integer id) {

    }
}
