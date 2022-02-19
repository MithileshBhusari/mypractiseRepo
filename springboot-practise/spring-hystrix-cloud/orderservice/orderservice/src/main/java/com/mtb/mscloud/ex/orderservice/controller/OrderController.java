package com.mtb.mscloud.ex.orderservice.controller;

import com.mtb.mscloud.ex.orderservice.common.Payment;
import com.mtb.mscloud.ex.orderservice.common.TransactionRequest;
import com.mtb.mscloud.ex.orderservice.common.TransactionResponse;
import com.mtb.mscloud.ex.orderservice.entity.Order;
import com.mtb.mscloud.ex.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MithileshB
 * @created 26/11/2021 - 2:53 PM
 * @project orderservice
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){

        return orderService.saveOrder(request);
    }
}
