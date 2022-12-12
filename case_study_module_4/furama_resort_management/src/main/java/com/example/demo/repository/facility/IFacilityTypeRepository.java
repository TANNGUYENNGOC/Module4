package com.example.demo.repository.facility;

import com.example.demo.model.facility.Facility;
import com.example.demo.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {

}
