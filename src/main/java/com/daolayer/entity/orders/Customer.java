package com.daolayer.entity.orders;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "customers")
public class Customer {
    @Id
    private Integer id;
    private String name;
    @Column(name = "surname")
    private String surName;
    private Integer age;
    private String phoneNumber;

    @OneToMany
    private List<Order> order;
}