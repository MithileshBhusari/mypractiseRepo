package com.mtb.webappproject.controller;

import com.mtb.webappproject.model.User;
import com.mtb.webappproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={ "/userCreation","/register","/"})
    public String mainPage() {
        System.out.println("This is the main Page");
        return "register.html";
    }


    @RequestMapping(value = "/signin")
    public String signup() {
        System.out.println("This is the signin Page");
        return "signin.html";
    }



    @RequestMapping(value = "/registerUser",
            method = RequestMethod.POST)
    public String registerUser(final User user, Model model) {
        System.out.println("Email: " + user.getEmail());
        model.addAttribute("email", user.getEmail());
        return "welcome";
    }

    @RequestMapping(value = "/signin",
            method = RequestMethod.POST)
    public String signInUser(final User user, Model model) {
        if(userService.validateUser(user.getUsername(),user.getPassword()) ){
            System.out.println("username: " + user.getUsername());
            model.addAttribute("username", user.getUsername());
            return "welcome";
        }else{
            System.out.println("Invalid Credentials");
            return "register.html";
        }
    }


}
