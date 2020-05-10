package com.mtb.springboot.mybatis.customer.model;

import java.util.List;

public class Customer {

    private int customerId;
    private String name;

    private List<Address> addresses;

    public Customer(int customerId, String name, List<Address> address) {
        this.customerId = customerId;
        this.name = name;
        this.addresses = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
