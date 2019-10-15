package com.iotknowyou.controller.Direct;

import com.iotknowyou.entity.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "Object")
public class ModelRecevicer {

    public void process(Person person){
        System.out.println("Receiver object massage :"+ person);
    }
}
