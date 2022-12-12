package com.example.demo.service.impl;

import com.example.demo.model.facility.RentType;
import com.example.demo.repository.facility.IRentypeRepository;
import com.example.demo.service.IRenTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenTypeService implements IRenTypeService {
    @Autowired
    IRentypeRepository rentypeRepository;
    @Override
    public Page<RentType> findAll(Pageable pageable) {
        return rentypeRepository.findAll(pageable);
    }

    @Override
    public Optional<RentType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(RentType rentType) {

    }

    @Override
    public void remove(Integer id) {

    }

}
