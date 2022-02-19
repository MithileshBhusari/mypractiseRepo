package com.mtb.springwithjmsex;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        SpringApplication.run(MainApp.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(MainApp.class, args);

        /*This is JmsTemplate  bean provided by Spring boot
        It used an internal ActiveMQ instance that was stood up by the spring boot.
        */

        Sender sender = context.getBean(Sender.class);

        sender.sendMessage("order-queue", "Hello Mithilesh !!!!!!!");

    }

    @Bean
    public JmsListenerContainerFactory myFactory(ConnectionFactory factory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        configurer.configure(containerFactory, factory);


        return containerFactory;
    }

    /*Because i am connecting directly to external ActiveMq instance, i need to
     * configure my connection factory by adding an ActiveMqConnection factory method*/
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        return activeMQConnectionFactory;
    }

    /*Next Spring configuration bean i will add  is my configurable JMS template  bean,
        to use the connection factory i have just specified,
     */
    @Bean
    public JmsTemplate getJmsTemplate() {
        return new JmsTemplate(connectionFactory());
    }


    /**
     * Spring Beam for listener of JMS messages
     */
    @Bean
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory());
        //containerFactory.setConcurrency("1-1");
        return containerFactory;
    }
}
