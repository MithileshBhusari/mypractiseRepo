package com.mtb.webappproject.controller;

import com.mtb.webappproject.model.User;
import com.mtb.webappproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {

        @RequestMapping(value="/")
        public String mainPage(){
            System.out.println("This is the main Page....Redirecting to  signup page");
         return "signup.html";
        }



    @RequestMapping(value = "/registerUser",
            method = RequestMethod.POST)
    public   String registerUser(final  User user,Model model) {
        System.out.println("Email: " + user.getEmail());
        //: " + user.getEmail());
   /*     System.out.println("httpServletRequest: " + httpServletRequest);
        System.out.println("httpServletResponse: " + httpServletResponse);*/
/*   RedirectView redirectView=new RedirectView("welcome");
   redirectView.addStaticAttribute("email",user.getEmail());*/
    model.addAttribute("email",user.getEmail());
        return "welcome";
    }

/*    @RequestMapping(value="/welcome"  )
    public String  welcome(Model model){
         *//*   ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("signup");
            return modelAndView;*//*
         //model.addAttribute("email",)
         return "welcome.html";
    }*/

}
