package com.mtb.exaxoncqrs.productservice.command.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MithileshB
 * @created 01/11/2021 - 7:08 AM
 * @project ProductService
 */

public interface ProductRepository extends JpaRepository<Product,String> {
}
