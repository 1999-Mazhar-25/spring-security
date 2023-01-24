package com.mazhar.security.service;

import com.mazhar.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {

    @Autowired
    private UserDetailsManager manager;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.manager.createUser(user);
    }


}
