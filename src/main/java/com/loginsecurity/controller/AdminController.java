package com.loginsecurity.controller;

import com.loginsecurity.bean.Role;
import com.loginsecurity.bean.User;
import com.loginsecurity.repository.RoleRepository;
import com.loginsecurity.repository.UserRepository;
import com.loginsecurity.service.RoleService;
import com.loginsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/updateRole")
    public String updateRole(){
        System.out.println("Update Role Initiated..");
        long i = 8;
        User user = userRepository.getOne(i);
        Role role = roleRepository.findByName("STUDENT");
        user.getRoles().clear();
        System.out.println(user.getName());
        System.out.println(user.getRoles().size());
        user.getRoles().add(roleRepository.findByName("ADMIN"));
        userRepository.save(user);

        System.out.println("terminal 1");
        System.out.println(user.getRoles().size());
        for(Role r : user.getRoles()){
            System.out.println(r.getName());
        }
        return "Terminal 1";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        userRepository.deleteById(1);
        return "Done";
    }

}
