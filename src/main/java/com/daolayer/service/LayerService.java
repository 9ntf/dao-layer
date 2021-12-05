package com.daolayer.service;

import com.daolayer.entity.persons.Persons;
import com.daolayer.repository.LayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LayerService {
    private final LayerRepository repository;

    public LayerService(LayerRepository repository) {
        this.repository = repository;
    }

    public String getFetchProduct(String name) {
        return repository.getProductName(name);
    }

    public List getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
