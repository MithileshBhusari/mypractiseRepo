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

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mtb.webappproject.constants.Constants.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin")
    public String signup() {
        System.out.println("signup: This is the signin Page");
        return SIGNIN;
    }


    @RequestMapping(value = "/signin",
                method = RequestMethod.POST)
    public String signInUser(final User user, Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (userService.validateUser(user.getUsername(), user.getPassword())) {
            System.out.println(" signInUser username: " + user.getUsername());
            model.addAttribute("username", user.getUsername());
            String username = (String) httpServletRequest.getSession().getAttribute("USERNAME");

            if (username == null) {
                httpServletRequest.getSession().setAttribute("USERNAME", user.getUsername());
            }
            httpServletRequest.getSession().setAttribute("USERNAME", user.getUsername());

            httpServletResponse.setHeader("Cache-Control", "no-cache");
            httpServletResponse.setHeader("Cache-Control", "no-store");
            httpServletResponse.setHeader("Pragma", "no-cache");
            httpServletResponse.setDateHeader("Expires", 0);
            return WELCOME;
        } else {
            System.out.println("Invalid Credentials");
            return HOMEPAGE;
        }
    }

    @GetMapping({"/homepage", "/"})
    public String home(Model model, HttpSession session) {
        List<String> usernameList = (List<String>) session.getAttribute("USERNAME_LIST");
        model.addAttribute("USERNAME_LIST", usernameList != null ? usernameList : new ArrayList<>());
        return HOMEPAGE;
    }

    @GetMapping({"/invalidate/session", "logout_page"})
    public String destroySession(HttpServletRequest request, HttpServletResponse httpServletResponse) {
        System.out.println("Destroying Session");
        System.out.println("Keep-Alive : " + httpServletResponse.getHeader("Keep-Alive"));
        request.getSession().invalidate();
        return LOGOUT;
    }
}
