package com.mtb.mscloud.ex.orderservice.common;

import com.mtb.mscloud.ex.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MithileshB
 * @created 26/11/2021 - 7:37 PM
 * @project orderservice
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private Order order;
    private Payment payment;
}
