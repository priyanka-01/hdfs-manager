package com.loginsecurity.service.impl;

import com.loginsecurity.bean.Role;
import com.loginsecurity.bean.User;
import com.loginsecurity.repository.RoleRepository;
import com.loginsecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getRoleFromEmail(User user)
    {
        if(user.getEmail().matches("^[a-zA-Z.0-9]+@iiitb\\.ac\\.in$")) {
            System.out.println("Fetched Role: "+roleRepository.findByName("ADMIN").getId());
            return roleRepository.findByName("ADMIN");
        }
        else if(user.getEmail().matches("^[a-zA-Z.0-9]+@iiitb\\.org$")) {
            System.out.println("Fetched Role: "+roleRepository.findByName("STUDENT").getId());
            return roleRepository.findByName("STUDENT");
        }
        System.out.println("Fetched Role: "+roleRepository.findByName("USER").getId());
        return roleRepository.findByName("USER");
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    public void addRole(String name){
        roleRepository.save(new Role(name));
    }
}
