package com.loginsecurity.service;

import com.loginsecurity.bean.Role;
import com.loginsecurity.bean.User;

public interface RoleService {
    public Role getRoleFromEmail (User user);
    public void save(Role role);
    public void addRole(String name);
}
