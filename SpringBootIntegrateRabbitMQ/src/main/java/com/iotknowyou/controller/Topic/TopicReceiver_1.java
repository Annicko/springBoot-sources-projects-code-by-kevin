package com.iotknowyou.controller.Topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver_1 {

    @RabbitHandler
    public void process(String message){
        System.out.println("Topic Receiver2 : "+ message);
    }
}
