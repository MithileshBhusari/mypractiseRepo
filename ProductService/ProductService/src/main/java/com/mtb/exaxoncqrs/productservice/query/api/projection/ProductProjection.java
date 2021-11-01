package com.mtb.exaxoncqrs.productservice.query.api.projection;

import com.mtb.exaxoncqrs.productservice.command.api.data.Product;
import com.mtb.exaxoncqrs.productservice.command.api.data.ProductRepository;
import com.mtb.exaxoncqrs.productservice.command.api.model.ProductRestModel;
import com.mtb.exaxoncqrs.productservice.query.api.queries.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MithileshB
 * @created 01/11/2021 - 7:56 AM
 * @project ProductService
 */
@Component
public class ProductProjection {

    private ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery){
        List<Product> products = productRepository.findAll();

        List<ProductRestModel> productRestModels = products.stream()
                .map(product -> ProductRestModel
                        .builder()
                        .quantity(product.getQuantity())
                        .name(product.getName())
                        .price(product.getPrice())
                        .build())
                .collect(Collectors.toList());
        return productRestModels;
    }
}
