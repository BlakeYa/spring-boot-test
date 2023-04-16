package org.example.mystarter;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.EventListenerFactory;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

// 自定义事件类
class MyEvent extends ApplicationEvent {
    private String message;

    public MyEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

// 事件监听器接口
interface MyEventListener extends ApplicationListener<MyEvent> {
}

// 事件监听器实现类
class MyEventListenerImpl implements MyEventListener {
    public void onApplicationEvent(MyEvent event) {
        System.out.println("MyEventListenerImpl: " + event.getMessage());
    }
}

// 配置类，用于注册事件监听器
@Configuration
class AppConfig {
    @Bean
    public MyEventListener myEventListener() {
        return new MyEventListenerImpl();
    }
}

// 测试类
public class ObserverPatternDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.publishEvent(new MyEvent(new ObserverPatternDemo(), "Hello, world!")); //MyEventListenerImpl: Hello, world!
    }
}
