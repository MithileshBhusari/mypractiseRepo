package com.sigma.jmspoc.listener;

import org.springframework.jms.annotation.JmsListener;

/**
 * @author MithileshB
 * @created 07/09/2020 - 5:42 PM
 * @project tdc-om-src
 */

public class JmsCustomListener {


    @JmsListener(destination = "poc-adapter-queue",containerFactory = "defaultJmsListenerContainerFactory")
    public void receiveMessage(String message){
        System.out.println("Message received :  "+message);


    }
}
