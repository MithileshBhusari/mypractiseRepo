package com.mtb.eurekaprovider.spring.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MithileshB
 * @created 28/10/2021 - 7:46 AM
 * @project payment-service
 */
@RestController
@RequestMapping("/payment-provider")
public class PaymentController {

    @GetMapping("/payNow/{price}")
    public String payNow(@PathVariable int price){
        return "Payment with "+price+" successful";
    }

}
