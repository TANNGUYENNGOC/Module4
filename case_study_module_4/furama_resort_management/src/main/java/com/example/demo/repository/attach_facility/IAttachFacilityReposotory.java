package com.example.demo.repository.attach_facility;

import com.example.demo.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachFacilityReposotory extends JpaRepository<AttachFacility,Integer> {
}
