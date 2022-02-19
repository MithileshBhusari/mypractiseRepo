package com.sigma.jmspoc.outbound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author MithileshB
 * @created 08/09/2020 - 8:44 PM
 * @project tdc-om-src
 */
public class ConsumerMessageListener implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerMessageListener.class);
    private String consumerName;
    public ConsumerMessageListener(String consumerName){
        LOGGER.info("in Constructor");
        this.consumerName=consumerName;
    }
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(consumerName + " received "
                    + textMessage.getText());

            LOGGER.info(consumerName + " received "
                    + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
