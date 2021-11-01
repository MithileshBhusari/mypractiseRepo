package com.mtb.exaxoncqrs.productservice.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author MithileshB
 * @created 01/11/2021 - 6:44 AM
 * @project ProductService
 */
@Data
@Builder
public class ProductRestModel {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
