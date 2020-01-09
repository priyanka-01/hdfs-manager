package com.loginsecurity.repository;

import com.loginsecurity.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
    public User findByEmail(String email);
    public void deleteById(long id);
  //  public User findById(long id);

}
