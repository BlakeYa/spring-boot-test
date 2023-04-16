package com.example.aop;

import com.example.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppControl {

    @Autowired
    UserService userService;

    @GetMapping
    public String getName(){
        userService.addUser();
//        userService.deleteUser();
        return "success";
    }
}
