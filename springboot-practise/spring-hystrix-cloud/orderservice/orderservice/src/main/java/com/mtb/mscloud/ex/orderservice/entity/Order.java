package com.mtb.mscloud.ex.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MithileshB
 * @created 26/11/2021 - 2:50 PM
 * @project orderservice
 */
@Entity
@Table(name = "Order_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private int id;
    private String name;
    private int qty;
    private double price;
}
