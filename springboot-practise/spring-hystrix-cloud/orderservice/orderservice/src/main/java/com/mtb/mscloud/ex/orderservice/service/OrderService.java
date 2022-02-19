package com.mtb.mscloud.ex.orderservice.service;

import com.mtb.mscloud.ex.orderservice.common.Payment;
import com.mtb.mscloud.ex.orderservice.common.TransactionRequest;
import com.mtb.mscloud.ex.orderservice.common.TransactionResponse;
import com.mtb.mscloud.ex.orderservice.entity.Order;
import com.mtb.mscloud.ex.orderservice.repository.OrderRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author MithileshB
 * @created 26/11/2021 - 2:52 PM
 * @project orderservice
 */

@Service
public class OrderService {

    @Autowired
    private OrderRepsitory orderRepsitory;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request){
String response="";
        Order order=request.getOrder();
        Payment payment=request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        Payment paymentResponse=restTemplate.postForObject("http://localhost:9191/payment/doPayment",payment,Payment.class);
        response=paymentResponse.getPaymentStatus().equals("success")?"Payment processing successful and order placed"
                :"there is failure in payment api,order added to cart";
         orderRepsitory.save(order);
         return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}
