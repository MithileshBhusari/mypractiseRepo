package com.mtb.exaxoncqrs.productservice.command.api.events;

import com.mtb.exaxoncqrs.productservice.command.api.data.Product;
import com.mtb.exaxoncqrs.productservice.command.api.data.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author MithileshB
 * @created 01/11/2021 - 7:05 AM
 * @project ProductService
 */
@Component
@ProcessingGroup("product")
public class ProductEventsHandler {

    private ProductRepository productRepository;


    public ProductEventsHandler(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) throws Exception {
        System.out.println("In on method of ProductEventsHandler");
        Product product=new Product();
        BeanUtils.copyProperties(productCreatedEvent,product);
        productRepository.save(product);
    }



    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
