package com.example.ioc_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MessageService messageService() {
        return new MessageServiceImpl();
    }

    @Bean
    public MessagePrinter messagePrinter() {
        MessagePrinter printer = new MessagePrinter();
        printer.setMessageService(messageService());
        return printer;
    }
}
