package com.daolayer.service;

import com.daolayer.repository.LayerRepository;
import org.springframework.stereotype.Service;

@Service
public class LayerService {
    private final LayerRepository repository;

    public LayerService(LayerRepository repository) {
        this.repository = repository;
    }

    public String getFetchProduct(String name) {
        return repository.getProductName(name);
    }
}
