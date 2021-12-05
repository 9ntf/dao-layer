package com.daolayer.entity.persons;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class Person implements Serializable {
    private String name;
    @Column(name = "surname")
    private String surName;
    private int age;
}
