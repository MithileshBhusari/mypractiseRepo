package com.sigma.jmspoc.outbound;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sigma.om.cmn.JsonUtils;
import com.sigma.om.engine.interaction.InteractionBuilderImpl;
import com.sigma.om.sdk.engine.interaction.Interaction;
import com.sigma.om.sdk.engine.interaction.InteractionState;
import com.sigma.om.sdk.engine.interaction.locator.InteractionResponseSenderLocator;
import com.sigma.om.sdk.order.enrichment.change.EnrichmentInfo;
import com.sigma.om.sdk.soi.ContentType;
import com.sigma.om.sdk.soi.framework.SoiContext;
import com.sigma.om.sdk.soi.interaction.ExternalInteractionState;
import com.sigma.om.sdk.soi.interaction.IMExternalInteraction;
import com.sigma.om.soi.framework.SoiConfig;
import com.sigma.om.soi.interaction.ExternalInteractionImpl;
import com.sigma.om.soi.interaction.ExternalResponseImpl;
import com.sigma.ps.tdc.om.soi.adapters.rals.resourceallocation.findDslamInfoByOrderNo.response.RalsFindDslamInfoByOrderNoResp;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.converter.ActiveMQMessageConverter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author MithileshB
 * @created 04/09/2020 - 2:15 PM
 * @project apache_jms_poc
 */
public class JmsOutbound extends RouteBuilder {
    public static final Logger LOGGER = LoggerFactory.getLogger(JmsOutbound.class);
    private static final String DEFAULT      = "DEFAULT";
    private static final String SKIP_TX = "skipTransaction";

    /* ObjectMapper instance */
    private static ObjectMapper objectMapper = new ObjectMapper();

    public void process(Exchange exchange) throws Exception {
        LOGGER.info("*********Inside JmsOutbound process method*******************");

        final SoiContext soiContext = SoiConfig.getSoIContextFromInBody(exchange);
        LOGGER.info("soiContext: {}",soiContext);
     //   final ExternalInteractionImpl extInt = (ExternalInteractionImpl) soiContext.getSoiExternalInteraction().get(0);

        try {
           final ExternalResponseImpl soiExtResponse = new ExternalResponseImpl();
        //    soiExtResponse.setExtInteractionId(extInt.getId());
    /*        final Response response = (Response) extInt.getResponses().get(0).getResponse();
            LOGGER.info(" status code {}", response.getStatus());

            final InputStream iStream = (InputStream) response.getEntity();
            final Writer writer = new StringWriter();
            final String inputEncoding = null;
            IOUtils.copy(iStream, writer, inputEncoding);

            final String responseString = writer.toString();*/
           // LOGGER.info(" responseString {}", responseString);
String responseBody="";
            for (final IMExternalInteraction extInteraction : soiContext.getSoiExternalInteraction()) {
                responseBody = extInteraction.getRequest();
                LOGGER.info(" ResponseBody : {} ", responseBody);
            }
    LOGGER.info("responseBody:{}",responseBody);
       //     extInt.setContentType(ContentType.JSON.name());
            soiExtResponse.setResponseString(responseBody);
            soiExtResponse.setResponse(responseBody);
            //extInt.addResponse(soiExtResponse);
            LOGGER.info("soiExtResponse:{}",soiExtResponse);

/*

            ActiveMQMessageConverter activeMQMessageConverter=new ActiveMQMessageConverter();

            Processor processor=activeMQMessageConverter.toProcessor(new ConsumerMessageListener("poc-adapter-queue"));
            LOGGER.info("processor:{}",processor);

            defaultJmsListenerContainerFactory();
*/



          /*  final RalsFindDslamInfoByOrderNoResp ralsFindDslamInfoByOrderNoResp = objectMapper.readValue(responseString, RalsFindDslamInfoByOrderNoResp.class);
            LOGGER.info("ralsFindDslamInfoByOrderNoResp: {}",ralsFindDslamInfoByOrderNoResp);
            if (ralsFindDslamInfoByOrderNoResp != null
                    && (ralsFindDslamInfoByOrderNoResp.getDslamInfo().getOnt() != null
                    || StringUtils.containsIgnoreCase(responseString, "xception"))
                    && !StringUtils.containsIgnoreCase(responseString, "INTERNAL_SERVER_ERROR")) {
                LOGGER.info("Inside If");
                notifyEngine(extInt, null);

            } else if (response.getStatus() != HttpStatus.SC_OK
                    || StringUtils.containsIgnoreCase(responseString, "xception")
                    || StringUtils.containsIgnoreCase(responseString, "\"FAULTY\"")) {
                LOGGER.info("Inside else if");
                notifyEngine(extInt, HttpStatus.getStatusText(response.getStatus()));
            } else {
                extInt.setAlternateKey(extInt.getId());
                LOGGER.info("Inside else");*/
            //    notifyEngine(extInt, null);
          //  }
        } catch (final Exception e) {
            LOGGER.error("Exception in JmsOutbound: ", e);
            //notifyEngine(extInt, e.getMessage());
        }
        LOGGER.info("After if block");
        //exchange.getIn().setBody(soiContext);
    }


    private void notifyEngine(ExternalInteractionImpl externalInteraction, String errMsg) throws Exception {
        final Interaction interaction = InteractionBuilderImpl.make(externalInteraction)
                .enrichmentInfo(new EnrichmentInfo()).build();

        LOGGER.info("ErrorString  {}", errMsg);

        if (StringUtils.isEmpty(errMsg)) {
            externalInteraction.setState(ExternalInteractionState.RUNNING);
            interaction.setState(InteractionState.RUNNING);
        } else {
            externalInteraction.setState(ExternalInteractionState.FAILED);
            externalInteraction.setErrorCode(DEFAULT);
            externalInteraction.setErrorDescription(errMsg);

            interaction.setState(InteractionState.FAILED);
            interaction.setErrorCode(DEFAULT);
            interaction.setErrorDescription(errMsg);
        }
        String interactionString= JsonUtils.toPlainFormattedString(interaction);
        LOGGER.debug("Interaction response {}", interactionString);
        InteractionResponseSenderLocator.getInstance().notify(interaction);
    }


    @Bean
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory());
        containerFactory.setConcurrency("1-1");
        LOGGER.info("containerFactory:{}",containerFactory);
        return containerFactory;
    }

    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        LOGGER.info("activeMQConnectionFactory:{}",activeMQConnectionFactory);
        return activeMQConnectionFactory;
      }

  /*  @Override
    @JmsListener(destination = "poc-adapter-queue",containerFactory = "defaultJmsListenerContainerFactory")
    public void onMessage(Message message) {
        LOGGER.info("Message:{}",message);
        TextMessage textMessage=(TextMessage)message;
        try {
            LOGGER.info("Message received:{} ",textMessage.getText());
        }catch (JMSException e){
            LOGGER.info("Exception in onMessage:{}",e);
        }
    }*/

    @Override
    public void configure() throws Exception {
        LOGGER.info("*********Inside JmsOutbound process method*******************");

        //   final ExternalInteractionImpl extInt = (ExternalInteractionImpl) soiContext.getSoiExternalInteraction().get(0);
        from("activemq:queue:codeusingjava-outputqueue").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                final SoiContext soiContext = SoiConfig.getSoIContextFromInBody(exchange);
                LOGGER.info("soiContext: {}",soiContext);

                final ExternalResponseImpl soiExtResponse = new ExternalResponseImpl();

                String responseBody="";
                for (final IMExternalInteraction extInteraction : soiContext.getSoiExternalInteraction()) {
                    responseBody = extInteraction.getRequest();
                    LOGGER.info(" ResponseBody : {} ", responseBody);
                }
                LOGGER.info("responseBody:{}",responseBody);
                //     extInt.setContentType(ContentType.JSON.name());
                soiExtResponse.setResponseString(responseBody);
                soiExtResponse.setResponse(responseBody);
                //extInt.addResponse(soiExtResponse);
                LOGGER.info("soiExtResponse:{}",soiExtResponse);
            }
        });

    }
}
