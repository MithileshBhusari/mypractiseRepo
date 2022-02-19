package com.mtb.mscloud.ex.paymentservice.service;

import com.mtb.mscloud.ex.paymentservice.entity.Payment;
import com.mtb.mscloud.ex.paymentservice.repository.PaymentRepisitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

/**
 * @author MithileshB
 * @created 26/11/2021 - 2:59 PM
 * @project paymentservice
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentRepisitory paymentRepisitory;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepisitory.save(payment);
    }

    public String paymentProcessing(){
        //api should be  3rd party payment gateway (paypal,paytm...)
        return new Random().nextBoolean()?"success":"failure";
    }
}
