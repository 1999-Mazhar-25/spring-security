package com.mazhar.security.Controller;

import com.mazhar.security.entity.User;
import com.mazhar.security.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCont {

    @Autowired
    MyUserService userService;

    @GetMapping("/index")
    public String hello(){
        return "Spring Security using userdetails manager";
    }


    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){

        this.userService.addUser(user);
        return "User Created Successfully !!!!";
    }
}
