package com.example.demo.service;

import com.example.demo.model.facility.Facility;

import java.util.List;

public interface IFacilityService extends IGeneralService<Facility>{
    List<Facility> findAll();

}
