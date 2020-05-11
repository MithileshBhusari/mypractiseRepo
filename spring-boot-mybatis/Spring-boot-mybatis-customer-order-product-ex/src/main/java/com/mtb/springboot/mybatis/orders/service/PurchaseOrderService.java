package com.mtb.springboot.mybatis.orders.service;

import com.mtb.springboot.mybatis.orders.mapper.PurchaseOrderMapper;
import com.mtb.springboot.mybatis.orders.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    public List<PurchaseOrder> getAllPurchaseOrders(int customerId) {
        return purchaseOrderMapper.getAllPurchaseOrders(customerId);
    }

    public PurchaseOrder getOrder(int id,int customerId) {
        return purchaseOrderMapper.getOrder(id,customerId);
    }

    public void addOrder(PurchaseOrder order,int customerId) {
        purchaseOrderMapper.addOrder(order,customerId);
    }

    public void deleteOrder(int id,int customerId) {
        purchaseOrderMapper.deleteOrder(id,customerId);
    }
}
