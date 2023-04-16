package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.*;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.PostConstruct;

/**
 * @author ：zhiwei liao
 * @date ：Created in 2022/01/09
 * @description:
 **/
//@EnableBinding({Source.class, Sink.class})
@SpringBootApplication
public class ScRocketMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScRocketMQApplication.class,args);
    }

    @PostConstruct
    public void setMsg(){
        MessageChannel messageChannel = new DirectChannel();

        // 消息订阅
        ((SubscribableChannel) messageChannel).subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println("===== receive msg: " + message.getPayload());
            }
        });

        // 消息发送
        messageChannel.send(MessageBuilder.withPayload("simple msg").build());
    }
}