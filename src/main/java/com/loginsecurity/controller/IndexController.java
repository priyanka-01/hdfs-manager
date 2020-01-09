package com.loginsecurity.controller;

import com.loginsecurity.security.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    AuthenticationFacade authenticationFacade;

    @GetMapping("/demo")
    public String demo(){
        displayLoggedInUser();
        return "index";
    }

    @GetMapping("/student")
    public String student(){
        displayLoggedInUser();
        return "student";
    }

    @GetMapping("/admin")
    public String admin(){
        displayLoggedInUser();
        return "admin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    public void displayLoggedInUser(){
        Authentication authentication = authenticationFacade.getAuthentication();
        String currentUserName ="";
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
            System.out.println("Logged in user: "+currentUserName);
        }
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/manageData")
    public String manageData(){
        return "manageData";
    }

}
