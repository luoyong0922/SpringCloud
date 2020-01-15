package com.roy.springcloud.configclient.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class ReceiverComponent {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver:" + hello);
    }
}