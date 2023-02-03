package com.mazhar.security.service;

import com.mazhar.security.entity.LoginUser;
import com.mazhar.security.entity.User;
import com.mazhar.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class LoginUserDeatilsServcie implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = this.userRepository.findByUsername(username)
                .orElse(new User());
        return new LoginUser(user);
    }
}
