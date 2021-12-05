package com.daolayer.entity.orders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@Table(name = "orders")
@AllArgsConstructor
public class Order {
    private String productName;

    @Override
    public String toString() {
        return productName;
    }
}