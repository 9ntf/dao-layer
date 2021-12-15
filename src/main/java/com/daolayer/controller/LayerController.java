package com.daolayer.controller;

import com.daolayer.entity.persons.Persons;
import com.daolayer.service.LayerService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
public class LayerController {
    private final LayerService service;

    public LayerController(LayerService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    //метод возвращает значения только для пользователей с ролью "READ"
    @Secured("ROLE_READ")
    public List getFetchProduct(@RequestParam("name") String name) {
        return service.getFetchProduct(name);
    }

    @GetMapping("/persons/by-city")
    @RolesAllowed("ROLE_WRITE")
    //метод возвращает значения только для пользователей с ролью "WRITE"
    public List getPersonsByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    //метод возвращает значения только для пользователей с ролью "WRITE или DELETE"
    public List getPersonsByAge(@RequestParam("age") Integer age) {
        return service.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-name")
    @PreAuthorize("@validationService.isValid(#userName)")
    //метод возвращает значения только для пользователя Alex
    public Optional getPersonByNameAndSurname(String userName, @RequestParam("name") String name, @RequestParam("surname") String surName) {
        return service.getByNameAndSurName(name, surName);
    }
}
