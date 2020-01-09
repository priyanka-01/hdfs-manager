package com.loginsecurity.service;

import com.loginsecurity.bean.User;

import java.util.List;

public interface UserService{
    public void save(User user);
    public User findByEmail(String email);
    public List<User> findAll();
}
