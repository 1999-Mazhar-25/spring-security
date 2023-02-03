package com.mazhar.security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCont {

    @GetMapping("/auth")
    public String hello(){
        return "This is 2 Step Authentication !!!";
    }
}
