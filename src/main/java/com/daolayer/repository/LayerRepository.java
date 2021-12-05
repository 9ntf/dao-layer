package com.daolayer.repository;

import com.daolayer.entity.orders.Order;
import com.daolayer.entity.persons.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class LayerRepository {
    private String myScriptOrders = read("myScriptOrders.sql");
    private String myScriptPersons = read("myScriptPersons.sql");

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    public String getProductName(String name) {
        Order order = namedParameterJdbcTemplate.queryForObject(myScriptOrders,
                Map.of("name", name,
                        "product_name", " "),
                (rs, rowNum) -> new Order(rs.getString("product_name")));
        return order.toString();
    }

    public List getPersonsByCity(String city) {
        Query query = entityManager.createQuery(myScriptPersons, Persons.class);
        query.setParameter("cityOfLiving", city.toUpperCase());
        query.getResultList().forEach(System.out::println);
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
