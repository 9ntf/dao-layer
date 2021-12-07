package com.daolayer.controller;

import com.daolayer.entity.persons.Persons;
import com.daolayer.service.LayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LayerController {
    private final LayerService service;

    public LayerController(LayerService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public List getFetchProduct(@RequestParam("name") String name) {
        return service.getFetchProduct(name);
    }

    @GetMapping("/persons/by-city")
    public List getPersonsByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List getPersonsByAge(@RequestParam("age") Integer age) {
        return service.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-name")
    public Optional getPersonByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surName) {
        return service.getByNameAndSurName(name, surName);
    }
}
