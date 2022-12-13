package com.example.demo.repository.facility;

import com.example.demo.dto.facility.IFacilityDTO1;
import com.example.demo.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    List<Facility> findAll();

    @Query(value = "select * from facility as f where (f.name like CONCAT('%',:name,'%') and f.facility_type_id like concat('%',:facilityType,'%')) and f.flag=0"
            ,countQuery = "select * from (select * from facility as f where (f.name like CONCAT('%',:name,'%') and f.facility_type_id like concat('%',:facilityType,'%')) and f.flag=0)ny;"
            , nativeQuery = true)
    Page<Facility> searchListFacility(@Param("name") String name, @Param("facilityType") String facilityType, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE facility SET flag = 1 WHERE id = :id",nativeQuery = true)
    void removeFlagFacility(@Param("id") int id);
}
