package mtb.observerex.readlearncode.services;

import com.mtb.observerex.readlearncode.Customer;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

/**
 * @author MithileshB
 * @created 19/07/2020 - 9:35 PM
 * @project DesignPattern
 */
public class AuthenticationService {

    public void createAuthenticationCredentials(@Observes @Priority(10) Customer customer){
        //Create Authentication for customer

    }
}
