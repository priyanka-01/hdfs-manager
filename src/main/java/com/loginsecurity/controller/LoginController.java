package com.loginsecurity.controller;

import com.loginsecurity.bean.User;
import com.loginsecurity.repository.UserRepository;
import com.loginsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public void signup(@RequestBody User user)
    {
        userService.save(user);
    }
}
