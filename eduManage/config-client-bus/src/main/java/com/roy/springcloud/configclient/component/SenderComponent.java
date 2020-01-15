package com.roy.springcloud.configclient.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SenderComponent {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send(){
        String content = "hello " + new Date();
        System.out.println("Sender:" +content);
        this.rabbitmqTemplate.convertAndSend("hello ", content);
    }
}