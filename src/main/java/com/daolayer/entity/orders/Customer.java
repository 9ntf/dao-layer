package com.daolayer.entity.orders;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

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

    @OneToMany(mappedBy = "customer")
    private Collection<Order> orders;
}