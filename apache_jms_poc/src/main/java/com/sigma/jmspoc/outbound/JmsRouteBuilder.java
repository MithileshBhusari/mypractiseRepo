package com.sigma.jmspoc.outbound;

import com.sigma.om.sdk.soi.framework.SoiContext;
import com.sigma.om.sdk.soi.interaction.IMExternalInteraction;
import com.sigma.om.soi.framework.SoiConfig;
import com.sigma.om.soi.framework.exception.SoiRuntimeException;
import com.sigma.om.soi.interaction.ExternalResponseImpl;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.io.input.ReaderInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

/**
 * @author MithileshB
 * @created 09/09/2020 - 6:31 PM
 * @project tdc-om-src
 */
public class JmsRouteBuilder extends RouteBuilder {
    public static final Logger LOGGER = LoggerFactory.getLogger(JmsRouteBuilder.class);
    private static final String SKIP_TX = "skipTransaction";
    private static final String DEFAULT ="DEFAULT" ;
    @Autowired
    private JmsTemplate jmsTemplate;
    public JmsRouteBuilder(){
        LOGGER.info("Inside JmsRouteBuilder");
    }

    @Bean
    private JmsTemplate getJmsTemplate() {
        return new JmsTemplate(connectionFactory());
    }

    public ActiveMQConnectionFactory connectionFactory() {
        LOGGER.info("connectionFactory");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        return activeMQConnectionFactory;
    }
    @Override
    public void configure() throws Exception {

        LOGGER.info("In configure method");
        jmsTemplate=getJmsTemplate();
        LOGGER.info("jmsTemplate:{}",jmsTemplate);

        from("activemq:queue:codeusingjava-inputqueue").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {

                LOGGER.info("Inside JMSSender process method");
                final SoiContext soiContext = SoiConfig.getSoIContextFromInBody(exchange);
                if (soiContext == null) {
                    throw new SoiRuntimeException(DEFAULT, "SoIContext CANNOT be null");
                }

                String requestBody = "";
                for (final IMExternalInteraction extInteraction : soiContext.getSoiExternalInteraction()) {
                    requestBody = extInteraction.getRequest();
                    LOGGER.info(" Request : {} ", requestBody);
                }

            }
        }).to("activemq:queue:codeusingjava-outputqueue");
    }
}
