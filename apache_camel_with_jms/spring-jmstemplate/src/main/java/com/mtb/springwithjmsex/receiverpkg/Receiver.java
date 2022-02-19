package com.mtb.springwithjmsex.receiverpkg;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author MithileshB
 * @created 30/08/2020 - 11:35 PM
 * @project apache_camel_with_jms
 */
@Component
public class Receiver {

    @JmsListener(destination = "order-queue",containerFactory = "myFactory")
    public void receiveMessage(String message){
        System.out.println("Message received :  "+message);
    }
}
