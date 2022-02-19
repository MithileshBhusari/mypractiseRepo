package com.mtb.springwithjmsex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

/**
 * @author MithileshB
 * @created 30/08/2020 - 11:29 PM
 * @project apache_camel_with_jms
 */
@EnableJms
@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class,args);
        ConfigurableApplicationContext context=SpringApplication.run(MainApp.class,args);
        JmsTemplate jmsTemplate=context.getBean(JmsTemplate.class);

        jmsTemplate.convertAndSend("order-queue","Hello Mithilesh !!!!!!!");
    }

    @Bean
    public JmsListenerContainerFactory myFactory(ConnectionFactory factory, DefaultJmsListenerContainerFactoryConfigurer configurer){
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        configurer.configure(containerFactory,factory);
        return containerFactory;
    }
}
