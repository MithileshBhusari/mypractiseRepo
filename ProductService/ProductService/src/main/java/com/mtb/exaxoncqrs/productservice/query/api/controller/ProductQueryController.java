package com.mtb.exaxoncqrs.productservice.query.api.controller;

import com.mtb.exaxoncqrs.productservice.command.api.model.ProductRestModel;
import com.mtb.exaxoncqrs.productservice.query.api.queries.GetProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MithileshB
 * @created 01/11/2021 - 7:50 AM
 * @project ProductService
 */
@RestController
@RequestMapping("/products")
public class ProductQueryController {

    private QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway){
        this.queryGateway=queryGateway;
    }
    @GetMapping
    public List<ProductRestModel> getAllProducts(){

        GetProductsQuery getProductsQuery=new GetProductsQuery();
        List<ProductRestModel> productRestModels=
        queryGateway.query(getProductsQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class))
                .join();
        return productRestModels;
    }
}
