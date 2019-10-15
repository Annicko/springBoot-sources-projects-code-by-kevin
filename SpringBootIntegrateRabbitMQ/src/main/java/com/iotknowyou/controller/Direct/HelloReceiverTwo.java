package com.iotknowyou.controller.Direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiverTwo {

    @RabbitHandler
    public void process(String Msg){
        System.out.println("ReceiverTwo receive massage :" + Msg);
    }
}
