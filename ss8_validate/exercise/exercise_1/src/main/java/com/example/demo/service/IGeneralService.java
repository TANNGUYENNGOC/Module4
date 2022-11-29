package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll(List list);

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
