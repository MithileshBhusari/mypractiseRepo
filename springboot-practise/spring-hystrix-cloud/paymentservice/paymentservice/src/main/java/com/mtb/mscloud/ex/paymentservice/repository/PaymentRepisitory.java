package com.mtb.mscloud.ex.paymentservice.repository;

import com.mtb.mscloud.ex.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MithileshB
 * @created 26/11/2021 - 2:58 PM
 * @project paymentservice
 */
public interface PaymentRepisitory extends JpaRepository<Payment,Integer>  {
}
