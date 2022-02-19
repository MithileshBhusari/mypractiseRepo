package com.sigma.jmspoc.transformer;

import com.sigma.om.sdk.order.Order;
import com.sigma.om.sdk.repo.locator.OrderRepositoryLocator;
import com.sigma.om.sdk.soi.ContentType;
import com.sigma.om.sdk.soi.framework.SoiContext;
import com.sigma.om.sdk.soi.framework.SoiRequest;
import com.sigma.om.sdk.soi.interaction.IMExternalInteraction;
import com.sigma.om.soi.framework.SOIAdapterUtils;
import com.sigma.om.soi.framework.SoiConfig;
import com.sigma.om.soi.framework.exception.RequestFailedException;
import com.sigma.ps.tdc.om.commons.envcfg.EnvironmentUtil;
import com.sigma.ps.tdc.om.commons.order.OrderUtils;
import com.sigma.ps.tdc.om.commons.soi.SoiMapping;
import com.sigma.ps.tdc.om.soi.adapters.rals.resourceallocation.findDslamInfoByOrderNo.request.RalsFindDslamInfoByOrderNoReq;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author MithileshB
 * @created 04/09/2020 - 2:14 PM
 * @project apache_jms_poc
 */
public class JmsTransformer implements Processor {
    public static final Logger LOGGER = LoggerFactory.getLogger(JmsTransformer.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        try {
            LOGGER.info("==============================================================\n" +
                                "*********Inside JMSTransformer process method***************" +
                            "\n===============================================================");
            LOGGER.debug("In Transformer: {}", exchange.getIn().getBody());
            final SoiContext context = SoiConfig.getSoIContextFromInBody(exchange);
            final String adapterName = SOIAdapterUtils.getSoiAdapter(exchange).getAdapterName();
            for (final SoiRequest soiRequest : context.getSoiRequestList()) {

                final List<IMExternalInteraction> soiExtInteractions = OrderUtils
                        .populateExternalInteractions(soiRequest);
                final Order order = OrderRepositoryLocator.getInstance().getOrder(soiRequest.getOrderRef().getKey());
                soiExtInteractions.get(0).setAlternateKey(soiExtInteractions.get(0).getId());

                RalsFindDslamInfoByOrderNoReq req=new RalsFindDslamInfoByOrderNoReq();
                req.setIspID("123");
                String request=SoiMapping.getJsonBuilder(req);
                soiExtInteractions.get(0).setRequest(request);
                soiExtInteractions.get(0).setContentType(ContentType.JSON.name());
                context.setSoiExternalInteractions(soiExtInteractions);
            }
            final Map<String, String> environmentConfig = EnvironmentUtil.getEnvConfig(adapterName);
       //     exchange.getIn().setHeader("requestUrl", environmentConfig.get(RalsConstants.FIBER.value()));
            exchange.getIn().setBody(context);

        } catch (final Exception e) {
            throw new RequestFailedException("Unable to create request:" + e.getMessage());
        }
    }
}
