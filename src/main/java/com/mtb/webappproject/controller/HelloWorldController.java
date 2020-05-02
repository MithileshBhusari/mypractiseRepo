package com.mtb.webappproject.controller;

import com.mtb.webappproject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/")
    public String mainPage() {
        System.out.println("This is the main Page");
        return "register.html";
    }


    @RequestMapping(value = "/registerUser",
            method = RequestMethod.POST)
    public String registerUser(final User user, Model model) {
        System.out.println("Email: " + user.getEmail());
        model.addAttribute("email", user.getEmail());
        return "welcome";
    }

}
