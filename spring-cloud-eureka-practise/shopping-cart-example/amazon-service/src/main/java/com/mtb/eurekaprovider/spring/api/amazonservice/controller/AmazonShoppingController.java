package com.mtb.eurekaprovider.spring.api.amazonservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author MithileshB
 * @created 28/10/2021 - 7:58 AM
 * @project amazon-service
 */
@RestController
public class AmazonShoppingController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/amazon-payment/{price}")
    public String invokePaymentService(@PathVariable int price){
        String url="http://PAYMENT-SERVICE/payment-provider/payNow/"+price;
        return restTemplate.getForObject(url,String.class);
    }
}
