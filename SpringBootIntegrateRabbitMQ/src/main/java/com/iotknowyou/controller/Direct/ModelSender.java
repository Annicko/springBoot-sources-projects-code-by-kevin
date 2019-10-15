package com.iotknowyou.controller.Direct;

import com.iotknowyou.entity.Person;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg(Person person){
        System.out.println("Sender Object massage :" + person.toString());
        this.amqpTemplate.convertAndSend("Object",person);
    }
}
