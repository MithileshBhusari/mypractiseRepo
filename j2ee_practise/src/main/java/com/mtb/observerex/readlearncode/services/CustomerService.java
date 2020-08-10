package com.mtb.observerex.readlearncode.services;

import com.mtb.observerex.readlearncode.Customer;
import com.mtb.observerex.readlearncode.CustomerEvent;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

/**
 * @author MithileshB
 * @created 19/07/2020 - 9:41 PM
 * @project DesignPattern
 */
public class CustomerService {

    public void createCustomer(@Observes @Priority(100) @CustomerEvent(CustomerEvent.Type.ADD) Customer customer){
        //add new customer
    }

    public void deleteCustomer(@Observes @CustomerEvent(CustomerEvent.Type.REMOVE) Customer customer){
        //delete the customer
    }
}
