package com.loginsecurity.security;

import com.loginsecurity.bean.User;
import com.loginsecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) {
        User user = null;
        try {
            user = this.userRepository.findByEmail(s);
        }catch (Exception exception){
            System.out.println("USER EXCEPTION");
            System.out.println(exception);
        }
        UserPrincipal userPrincipal = new UserPrincipal(user);
        System.out.println(userPrincipal.getUsername());
        return userPrincipal;
    }
}
