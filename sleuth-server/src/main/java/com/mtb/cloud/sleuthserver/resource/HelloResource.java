package com.mtb.cloud.sleuthserver.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MithileshB
 * @created 24/02/2021 - 7:59 AM
 * @project sleuth-server
 */
@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

    private static final Logger LOGGER= LoggerFactory.getLogger(HelloResource.class);
    @GetMapping(value = "/server")
    public String hello() {
        LOGGER.info("Reached Server");
        return "Hello World";
    }
}
