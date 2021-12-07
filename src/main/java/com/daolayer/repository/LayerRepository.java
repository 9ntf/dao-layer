package com.daolayer.repository;

import com.daolayer.entity.orders.Order;
import com.daolayer.entity.persons.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LayerRepository {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    OrderRepository orderRepository;


   @Transactional
    public List getProductName(String name) {
        return orderRepository.findByCustomerName(name);
    }

    @Transactional
    public List getPersonsByCity(String city) {
        return personRepository.findByCityOfLiving(city.toLowerCase());
    }

    @Transactional
    public List getPersonsByAge(Integer age) {
       return personRepository.findByHumanAgeLessThanOrderByHumanAge(age);
    }

    @Transactional
    public Optional getByNameAndSurName(String name, String surName){
       return personRepository.findByHumanNameAndHumanSurName(name, surName);
    }
}
