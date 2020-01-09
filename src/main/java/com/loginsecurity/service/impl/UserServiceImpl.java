package com.loginsecurity.service.impl;

import com.loginsecurity.bean.Role;
import com.loginsecurity.bean.User;
import com.loginsecurity.repository.RoleRepository;
import com.loginsecurity.repository.UserRepository;
import com.loginsecurity.service.RoleService;
import com.loginsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleService.getRoleFromEmail(user);
        if(role.getName() != "USER")
            user.getRoles().add(roleRepository.findByName("USER"));
        user.getRoles().add(roleService.getRoleFromEmail(user));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
