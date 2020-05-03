package com.mtb.webappproject.controller;

import com.mtb.webappproject.model.User;
import com.mtb.webappproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin")
    public String signup() {
        System.out.println("signup: This is the signin Page");
        return "signin";
    }


    @RequestMapping(value = "/signin",
            method = RequestMethod.POST)
    public String signInUser(final User user, Model model, HttpServletRequest httpServletRequest) {
        if (userService.validateUser(user.getUsername(), user.getPassword())) {
            System.out.println(" signInUser username: " + user.getUsername());
            model.addAttribute("username", user.getUsername());

          //  List<String> usernameList = (List<String>) httpServletRequest.getSession().getAttribute("USERNAME_LIST");
        String username =(String)    httpServletRequest.getSession().getAttribute("USERNAME");

            if (username == null) {
                //usernameL = new ArrayList<>();
                //username.add(user.getUsername());
                //httpServletRequest.getSession().setAttribute("USERNAME_LIST", usernameList);
                httpServletRequest.getSession().setAttribute("USERNAME", user.getUsername());
            }
            //usernameList.add(user.getUsername());
            //httpServletRequest.getSession().setAttribute("USERNAME_LIST", usernameList);
            httpServletRequest.getSession().setAttribute("USERNAME", user.getUsername());
            return "welcome";
        } else {
            System.out.println("Invalid Credentials");
            return "homepage";
        }
    }

    @GetMapping({"/homepage", "/"})
    public String home(Model model, HttpSession session) {
        List<String> usernameList = (List<String>) session.getAttribute("USERNAME_LIST");
        model.addAttribute("USERNAME_LIST", usernameList != null ? usernameList : new ArrayList<>());
        return "homepage";
    }

    @PostMapping("/invalidate/session")
    public String destroySession(HttpServletRequest request) {
        //invalidate the session , this will clear the data from configured database (Mysql/redis/hazelcast)
        System.out.println("Destroying Session");
        request.getSession().invalidate();
        return "homepage";
    }
}
