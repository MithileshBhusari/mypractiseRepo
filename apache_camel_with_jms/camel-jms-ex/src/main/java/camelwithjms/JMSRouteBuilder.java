package com.mtb.camelwithjms;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * @author MithileshB
 * @created 30/08/2020 - 8:32 PM
 * @project apache_camel_with_jms
 */
public class JMSRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jmsComponent:queue:codeusingjava-inputqueue").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println(exchange.getIn().getBody());
            }
        }).to("jmsComponent:queue:codeusingjava-outputqueue");
    }

}