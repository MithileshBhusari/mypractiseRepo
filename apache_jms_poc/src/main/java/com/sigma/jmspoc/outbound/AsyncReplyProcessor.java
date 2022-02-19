package com.sigma.jmspoc.outbound;

import com.sigma.om.repo.util.SoiRepositoryImpl;
import com.sigma.om.sdk.repo.SoiRepository;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.converter.ActiveMQMessageConverter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

public class AsyncReplyProcessor implements Processor {

    private static final Logger        LOGGER        = LoggerFactory
            .getLogger(AsyncReplyProcessor.class.getName());
    private static final SoiRepository soiRepository = new SoiRepositoryImpl();

    @Override
    public void process(Exchange exchange) {
        LOGGER.info("Inside AsyncReplyProcessor  process() method");

        ActiveMQMessageConverter activeMQMessageConverter=new ActiveMQMessageConverter();
        Processor processor=activeMQMessageConverter.toProcessor(new ConsumerMessageListener("poc-adapter-queue"));




     /*   try {

            final SoiAyncExternalResponse soiExternalResponse = exchange.getIn()
                    .getBody(SoiAyncExternalResponse.class);
            LOGGER.info("soiExternalResponse:{}",soiExternalResponse);

            final String responseStr = soiExternalResponse.getMessage();
            LOGGER.debug("response {} ", responseStr);
            String responseAfterState = StringUtils.substringAfter(responseStr, "state\":");
            String state = org.apache.commons.lang.StringUtils.substringBefore(responseAfterState, ",");
            LOGGER.info("State: {}", state);
            final ExternalResponseImpl soiExtResponse = new ExternalResponseImpl();
            soiExtResponse.setResponseString(responseStr);
            soiExtResponse.setResponse(responseStr);
            final String altKey = soiExternalResponse.getExternalKey();
            LOGGER.info("alternate key is {}", altKey);

            final ExternalInteractionImpl externalInteraction = (ExternalInteractionImpl) soiRepository
                    .getSoiExtInteraction(altKey);
            soiExtResponse.setExtInteractionId(externalInteraction.getId());
            externalInteraction.setContentType(ContentType.JSON.name());
            externalInteraction.addResponse(soiExtResponse);

            final Interaction interaction = InteractionBuilder.make(externalInteraction).build();

            if (StringUtils.isEmpty(responseStr) || responseStr.contains("xception")
                    || !StringUtils.containsIgnoreCase(responseStr, "\"complete\"")) {
                externalInteraction.setState(ExternalInteractionState.FAILED);
                externalInteraction.setErrorCode("DEFAULT ERROR");
                externalInteraction.setErrorDescription("state:" + state);
                interaction.setState(InteractionState.FAILED);
                interaction.setErrorCode("DEFAULT_ERROR");
                interaction.setErrorDescription("state:" + state);
            } else {
                externalInteraction.setState(ExternalInteractionState.DONE);
                interaction.setState(InteractionState.DONE);
            }

            InteractionResponseSenderLocator.getInstance().notify(interaction);
            exchange.getOut().setBody(externalInteraction);
         }catch(Exception e) {
            throw new SoiRuntimeException("DEFAULT_ERROR");
        }*/
    }

    @JmsListener(destination = "poc-adapter-queue",containerFactory = "defaultJmsListenerContainerFactory")
    public void receiveMessage(String message){
        LOGGER.info("Message received :  "+message);

    }

    @Bean
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory());
        //containerFactory.setConcurrency("1-1");
        return containerFactory;
    }

    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        return activeMQConnectionFactory;
    }
}