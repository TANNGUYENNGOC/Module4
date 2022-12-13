package com.example.demo.dto.facility;

import com.example.demo.model.facility.FacilityType;
import com.example.demo.model.facility.RentType;


public interface IFacilityDTO1 {
     int getId();
     String getName();
     int getArea();
     double getCost();
     int getMaxPeople();
     RentType getRentType();
     FacilityType getFacilityType();
     String getStandardRoom();
     String getDescriptionOtherConvenience();
     double getPoolArea();
     int getNumberOfFloos();
     String getFacilityFree();
}
