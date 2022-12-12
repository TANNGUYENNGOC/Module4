package com.example.demo.repository.facility;

import com.example.demo.model.facility.Facility;
import com.example.demo.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRentypeRepository extends JpaRepository<RentType,Integer> {

}
