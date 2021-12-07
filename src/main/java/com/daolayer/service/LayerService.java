package com.daolayer.service;

import com.daolayer.entity.persons.Persons;
import com.daolayer.repository.LayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LayerService {
    private final LayerRepository repository;

    public LayerService(LayerRepository repository) {
        this.repository = repository;
    }

    public List getFetchProduct(String name) {
        return repository.getProductName(name);
    }

    public List getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

    public List getPersonsByAge(Integer age) {
        return repository.getPersonsByAge(age);
    }

    public Optional getByNameAndSurName(String name, String surName) {
        return repository.getByNameAndSurName(name, surName);
    }
}
