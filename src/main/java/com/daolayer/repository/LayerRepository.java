package com.daolayer.repository;

import com.daolayer.entity.orders.Order;
import com.daolayer.entity.persons.Persons;
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
import java.util.stream.Collectors;

@Repository
public class LayerRepository {
    private String myScriptOrders = read("myScriptOrders.sql");
    private String myScriptPersons = read("myScriptPersons.sql");

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List getProductName(String name) {
        Query query = entityManager.createQuery(myScriptOrders, Order.class);
        query.setParameter("name", name);
        System.out.println(query.getResultList());
        return query.getResultList();
    }

    @Transactional
    public List getPersonsByCity(String city) {
        Query query = entityManager.createQuery(myScriptPersons, Persons.class);
        query.setParameter("cityOfLiving", city);
        return query.getResultList();
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
