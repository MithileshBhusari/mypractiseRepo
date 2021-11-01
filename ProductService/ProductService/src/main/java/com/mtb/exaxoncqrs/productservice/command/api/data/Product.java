package com.mtb.exaxoncqrs.productservice.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author MithileshB
 * @created 01/11/2021 - 7:06 AM
 * @project ProductService
 */
@Data
@Entity
public class Product {

    @Id
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

}
