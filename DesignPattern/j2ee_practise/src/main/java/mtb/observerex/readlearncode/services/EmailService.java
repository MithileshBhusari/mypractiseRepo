package mtb.observerex.readlearncode.services;

import com.mtb.observerex.readlearncode.Customer;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

/**
 * @author MithileshB
 * @created 19/07/2020 - 9:42 PM
 * @project DesignPattern
 */
public class EmailService {
    public void sendWelcomeEmail(@Observes @Priority(1000) Customer customer){
        //Send Welcome email to customer
    }
}
