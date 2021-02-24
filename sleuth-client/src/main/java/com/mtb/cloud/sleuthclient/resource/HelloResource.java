package com.mtb.cloud.sleuthclient.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author MithileshB
 * @created 24/02/2021 - 7:53 AM
 * @project sleuth-client
 */
@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloResource.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "")
    public String hello() {
        LOGGER.info("Before Calling the server");
        String response = restTemplate.getForObject("http://localhost:8083/rest/hello/server", String.class);
        LOGGER.info("After calling the server");
        return response;
    }
}
