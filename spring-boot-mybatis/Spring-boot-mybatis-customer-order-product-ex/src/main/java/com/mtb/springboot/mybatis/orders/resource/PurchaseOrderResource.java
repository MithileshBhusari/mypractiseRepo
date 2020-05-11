package com.mtb.springboot.mybatis.orders.resource;

import com.mtb.springboot.mybatis.orders.model.PurchaseOrder;
import com.mtb.springboot.mybatis.orders.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customers/{customerId}/orders")
public class PurchaseOrderResource {


    @Autowired
    private PurchaseOrderService purchaseOrderService;


    @GetMapping("/getAllOrders")
    public List<PurchaseOrder> getAllPurchaseOrders(@PathVariable int customerId) {
        return purchaseOrderService.getAllPurchaseOrders(customerId);
    }


    @GetMapping("/{id}")
    public PurchaseOrder getPurchaseOrder(@PathVariable int id,@PathVariable int customerId) {
        return purchaseOrderService.getOrder(id,customerId);
    }

    @PostMapping("/addOrder")
    private void addOrder(@RequestBody PurchaseOrder order,@PathVariable int customerId) {
        purchaseOrderService.addOrder(order,customerId);
    }

    @DeleteMapping("/{id}")
    private void deleteOrder(@PathVariable int id,@PathVariable int customerId) {
        purchaseOrderService.deleteOrder(id,customerId);
    }




}
