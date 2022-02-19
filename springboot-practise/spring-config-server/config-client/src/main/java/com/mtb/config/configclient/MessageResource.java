package com.mtb.config.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MithileshB
 * @created 15/01/2022 - 5:15 PM
 * @project config-client
 */
@RequestMapping("/rest")
@RestController
@RefreshScope
public class MessageResource {

        @Value("${message: Default Hello}")
        private String message;

        @GetMapping("/message")
        public String message(){
            return message;
        }
}
