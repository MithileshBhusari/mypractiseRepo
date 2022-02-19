package com.mtb.mscloud.ex.orderservice.repository;

import com.mtb.mscloud.ex.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MithileshB
 * @created 26/11/2021 - 2:51 PM
 * @project orderservice
 */
public interface OrderRepsitory  extends JpaRepository<Order,Integer> {
}
