package com.iotknowyou.controller.Fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "FanoutB")
public class FanoutReceiverB {
    @RabbitHandler
    public void process(String message){
        System.out.println("Fanout Receiver B : "+ message);
    }
}
