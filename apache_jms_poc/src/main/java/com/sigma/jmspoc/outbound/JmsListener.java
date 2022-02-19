package com.sigma.jmspoc.outbound;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.converter.ActiveMQMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author MithileshB
 * @created 08/09/2020 - 7:42 PM
 * @project tdc-om-src
 */
@Component
public class JmsListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(JmsListener.class);



    @org.springframework.jms.annotation.JmsListener(destination = "poc-adapter-queue")
    public void receiveMessage(String message){

        LOGGER.info("Message received :  "+message);
     //   System.out.println("Message received :  "+message);
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        LOGGER.info("jmsTemplate()");
        return new JmsTemplate(connectionFactory());
    }

    @Bean
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
        LOGGER.info("defaultJmsListenerContainerFactory()");
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory());
        containerFactory.setConcurrency("1-1");
        return containerFactory;
    }

    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        return activeMQConnectionFactory;
    }
}
