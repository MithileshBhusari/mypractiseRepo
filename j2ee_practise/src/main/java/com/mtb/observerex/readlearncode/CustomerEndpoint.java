package com.mtb.observerex.readlearncode;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * @author MithileshB
 * @created 19/07/2020 - 9:31 PM
 * @project DesignPattern
 */
@Stateless
@Path("/customers")
public class CustomerEndpoint {

    @Inject @CustomerEvent(CustomerEvent.Type.ADD)
    private Event<Customer> customerAddEvent;

    @Inject @CustomerEvent(CustomerEvent.Type.REMOVE)
    private Event<Customer> customerRemoveEvent;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void newCustomer(Customer customer){
        customerAddEvent.fire(customer);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeCustomer(Customer customer){
        customerRemoveEvent.fire(customer);
    }
}
