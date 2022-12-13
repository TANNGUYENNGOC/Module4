package com.example.demo.service;

import com.example.demo.dto.facility.IFacilityDTO1;
import com.example.demo.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityService extends IGeneralService<Facility>{
    List<Facility> findAll();
    Page<Facility> searchListFacility(String name, String facilityType, Pageable pageable);
    void removeFlagFacility(int id);
}
