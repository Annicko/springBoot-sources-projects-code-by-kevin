package com.iotknowyou.controller.Direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg(int index){
        String context = "hello Queue : "+ index +"\t"+ new Date();
        System.out.println("Sender :" + context);
        this.amqpTemplate.convertAndSend("hello",context);
    }
}
