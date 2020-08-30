package com.mtb.camelwithjms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

/**
 * @author MithileshB
 * @created 30/08/2020 - 8:33 PM
 * @project apache_camel_with_jms
 */
public class CamelMain {
    public static void main(String[] args) {
        CamelContext ctx = new DefaultCamelContext();

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        ctx.addComponent("jmsComponent", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        com.mtb.camelwithjms.JMSRouteBuilder jmsRouteBuilder = new com.mtb.camelwithjms.JMSRouteBuilder();

        try {
            ctx.addRoutes(jmsRouteBuilder);
            ctx.start();
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
