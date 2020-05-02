package com.mtb.webappproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

        @RequestMapping("/")
        public String  signup(){
         /*   ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("signup");
            return modelAndView;*/
         return "signup.html";
        }
}
