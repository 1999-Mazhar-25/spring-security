package com.mazhar.security.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCont {

    @GetMapping("/auth")
    public String hello(){
        Authentication auth =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        System.out.println(auth.getName());
        return "Hi Authenticated Object ??" ;
    }
}
