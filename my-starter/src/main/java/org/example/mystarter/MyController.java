package org.example.mystarter;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        Future<?> submit = threadPoolTaskExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("======");
            }
        });


        return "Hello from My Starter!";

    }
}
