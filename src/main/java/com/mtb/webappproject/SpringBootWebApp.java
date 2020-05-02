package com.mtb.webappproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;


@SpringBootApplication
public class SpringBootWebApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApp.class,args);
    }
}
