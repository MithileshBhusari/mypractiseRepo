package com.mtb.webappproject.controller;

import com.mtb.webappproject.model.User;
import com.mtb.webappproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/userCreation", "/register"})
    public String mainPage() {
        System.out.println("This is the main Page");
        return "register.html";
    }

    @RequestMapping(value = "/registerUser",
            method = RequestMethod.POST)
    public String registerUser(final User user, Model model, HttpServletResponse httpServletResponse) {
        System.out.println("Email: " + user.getEmail());
        model.addAttribute("email", user.getEmail());
        return "welcome";
    }


    @RequestMapping(value = "/showUsers",
            method = RequestMethod.POST)
    public List<User> showUsers(final User user, Model model) {

        return userService.getUsersList();
        //return "welcome";
    }

    @RequestMapping(value = "/showUsers",
            method = RequestMethod.GET)
    public List<User> getUsers(final User user, Model model) {

        return userService.getUsersList();
        //return "welcome";
    }

}
