package com.daolayer.repository;

import com.daolayer.entity.persons.Human;
import com.daolayer.entity.persons.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Persons, Human> {

    //Нахождение по городу
    List<Persons> findByCityOfLiving (String city);

    //Нахождение по возрасту и отсортировка
    List<Persons> findByHumanAgeLessThanEqualOrderByHumanAge(Integer age);

    //Нахождение по имени и фамилии
    Optional<Persons> findByHumanNameAndHumanSurName(String name, String surName);
}
