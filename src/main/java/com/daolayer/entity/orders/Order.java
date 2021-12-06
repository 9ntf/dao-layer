package com.daolayer.entity.orders;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Integer id;
    private LocalDate date;
    private String productName;
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}