package com.mtb.exaxoncqrs.productservice.command.api.exception;

import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.EventMessageHandler;
import org.axonframework.eventhandling.ListenerInvocationErrorHandler;

/**
 * @author MithileshB
 * @created 01/11/2021 - 9:10 AM
 * @project ProductService
 */
public class ProductServiceEventsErrorHandler implements ListenerInvocationErrorHandler {

    @Override
    public void onError(Exception e, EventMessage<?> eventMessage, EventMessageHandler eventMessageHandler) throws Exception {
        System.out.println("Exception occurred:"+e.getMessage());
        throw  e;

    }
}
