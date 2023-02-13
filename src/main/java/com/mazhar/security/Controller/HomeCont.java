package com.mazhar.security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeCont {

    @GetMapping("/home")
    public String hello(){
        return "home.html";
    }



    @PostMapping("/save")
    public String save(String data){

        System.out.println("this is data from server"+ data);
        return "home.html";
    }
}
