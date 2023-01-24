package com.mazhar.security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCont {

    @GetMapping("/")
    public String hello(){
        return "this is in controller";
    }
}
