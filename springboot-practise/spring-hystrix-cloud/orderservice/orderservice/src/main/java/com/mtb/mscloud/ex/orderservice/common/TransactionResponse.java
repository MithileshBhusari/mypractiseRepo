package com.mtb.mscloud.ex.orderservice.common;

import com.mtb.mscloud.ex.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MithileshB
 * @created 26/11/2021 - 7:39 PM
 * @project orderservice
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private Order order;
    private double  amount;
    private String transactionId;
    private String message;

}
