package com.daolayer.entity.orders;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Integer id;
    private LocalDate date;
    private String productName;
    private Integer amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customers_id")
    private Customer customer;
}