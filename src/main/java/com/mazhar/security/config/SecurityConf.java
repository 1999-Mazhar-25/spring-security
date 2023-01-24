package com.mazhar.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConf {

    @Bean
    public UserDetailsService userDetailsService(){

        System.out.println("this is before creating user details manager");
        InMemoryUserDetailsManager userDet= new InMemoryUserDetailsManager();
        System.out.println("this is before creating user ");
        User user = (User) User.withUsername("Mazhar")
                .password("MF123")
                .roles("read")
                .build();
        userDet.createUser(user);
        return userDet;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        System.out.println("this is before getting password encoder");
        return NoOpPasswordEncoder.getInstance();
    }

}
