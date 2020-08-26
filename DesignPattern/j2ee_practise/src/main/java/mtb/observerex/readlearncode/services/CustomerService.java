package mtb.observerex.readlearncode.services;

import mtb.observerex.readlearncode.Customer;
import mtb.observerex.readlearncode.CustomerEvent;


import javax.annotation.Priority;
import javax.enterprise.event.ObservesAsync;

/**
 * @author MithileshB
 * @created 19/07/2020 - 9:41 PM
 * @project DesignPattern
 */
public class CustomerService {

    public void createCustomer(@ObservesAsync @Priority(100) @CustomerEvent(CustomerEvent.Type.ADD) Customer customer){
        //add new customer
    }

    public void deleteCustomer(@ObservesAsync @CustomerEvent(CustomerEvent.Type.REMOVE) Customer customer){
        //delete the customer
    }
}
