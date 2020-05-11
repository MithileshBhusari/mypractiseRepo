package com.mtb.springboot.mybatis.customer.model;

import com.mtb.springboot.mybatis.orders.model.PurchaseOrder;

import java.util.List;

public class Customer {

    private int customerId;
    private String name;
    private List<Address> addresses;
    private List<PurchaseOrder> purchaseOrderList;

    public List<PurchaseOrder> getPurchaseOrderList() {
        return purchaseOrderList;
    }

    public void setPurchaseOrderList(List<PurchaseOrder> purchaseOrderList) {
        this.purchaseOrderList = purchaseOrderList;
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
