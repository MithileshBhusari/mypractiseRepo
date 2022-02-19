package com.mtb.springwithjmsex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author MithileshB
 * @created 04/09/2020 - 8:40 PM
 * @project apache_camel_with_jms
 */
@Component
public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String destination,String message){
        jmsTemplate.convertAndSend(destination,message);
    }

}
