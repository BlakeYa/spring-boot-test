package com.example.ioc_test;

public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "Hello, Spring IoC!";
    }
}