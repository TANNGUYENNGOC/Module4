package com.example.demo.service.impl;

import com.example.demo.model.facility.FacilityType;
import com.example.demo.repository.facility.IFacilityRepository;
import com.example.demo.repository.facility.IFacilityTypeRepository;
import com.example.demo.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    IFacilityTypeRepository facilityTypeRepository;
    @Override
    public Page<FacilityType> findAll(Pageable pageable) {
        return facilityTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<FacilityType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(FacilityType facilityType) {

    }

    @Override
    public void remove(Integer id) {

    }

}
