package com.mtb.mscloud.ex.paymentservice.controller;

import com.mtb.mscloud.ex.paymentservice.entity.Payment;
import com.mtb.mscloud.ex.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MithileshB
 * @created 26/11/2021 - 3:01 PM
 * @project paymentservice
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        System.out.println("payment:"+payment);
       return paymentService.doPayment(payment);
    }
}
