package com.mtb.springboot.mybatis.orders.resource;

import com.mtb.springboot.mybatis.orders.model.PurchaseOrder;
import com.mtb.springboot.mybatis.orders.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PurchaseOrderResource {


    @Autowired
    private PurchaseOrderService purchaseOrderService;


    @GetMapping("/customers/{customerId}/orders/getAllOrders")
    public List<PurchaseOrder> getAllPurchaseOrders(@PathVariable int customerId) {
        return purchaseOrderService.getAllPurchaseOrders(customerId);
    }


    @GetMapping("customers/{customerId}/orders/{id}")
    public PurchaseOrder getPurchaseOrder(@PathVariable int id,@PathVariable int customerId) {
        return purchaseOrderService.getOrder(id,customerId);
    }

    @PostMapping("/customers/{customerId}/orders/addOrder")
    private void addOrder(@RequestBody PurchaseOrder order,@PathVariable int customerId) {
        purchaseOrderService.addOrder(order,customerId);
    }

    @DeleteMapping("/customers/{customerId}/orders/{id}")
    private void deleteOrder(@PathVariable int id,@PathVariable int customerId) {
        purchaseOrderService.deleteOrder(id,customerId);
    }




}
