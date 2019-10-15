package com.iotknowyou.controller.Fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send(){
        String context = "hi , i am fanout message ";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("fanoutExchange","",context);
    }
}
