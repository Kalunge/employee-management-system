package com.titusm.springbootdemo.controller;

import com.titusm.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "hello  and welcome to my application I am a java programmer ";
    }

    @GetMapping("/user")
    public User userInfo() {
        User user = new User();
        user.setId("1");
        user.setName("Titus Muthomi");
        user.setEmailId("titus@mail.com");

        return user;
    }

}
