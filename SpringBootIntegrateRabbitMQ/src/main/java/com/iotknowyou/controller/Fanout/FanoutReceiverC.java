package com.iotknowyou.controller.Fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "FanoutC")
public class FanoutReceiverC {
    @RabbitHandler
    public void process(String message){
        System.out.println("Fanout Receiver C : "+ message);
    }
}
