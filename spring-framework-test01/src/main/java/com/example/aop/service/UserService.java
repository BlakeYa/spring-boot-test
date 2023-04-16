package com.example.aop.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {

    public void addUser() {
        System.out.println("添加用户");
    }

    public void deleteUser() {
        System.out.println("删除用户");
    }

}
