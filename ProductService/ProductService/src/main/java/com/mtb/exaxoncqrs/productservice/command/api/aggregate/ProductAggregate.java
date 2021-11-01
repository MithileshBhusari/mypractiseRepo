package com.mtb.exaxoncqrs.productservice.command.api.aggregate;

import com.mtb.exaxoncqrs.productservice.command.api.commands.CreateProductCommand;
import com.mtb.exaxoncqrs.productservice.command.api.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * @author MithileshB
 * @created 01/11/2021 - 6:53 AM
 * @project ProductService
 */
@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
            //perform all validations
        System.out.println("In ProductAggregate");
        ProductCreatedEvent productCreatedEvent=new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand,productCreatedEvent);
        AggregateLifecycle.apply(productCreatedEvent);
    }
       public ProductAggregate(){
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        System.out.println("In on method of ProductAggregate");
        this.name=productCreatedEvent.getName();
        this.price=productCreatedEvent.getPrice();
        this.quantity=productCreatedEvent.getQuantity();
        this.productId=productCreatedEvent.getProductId();
    }

}
