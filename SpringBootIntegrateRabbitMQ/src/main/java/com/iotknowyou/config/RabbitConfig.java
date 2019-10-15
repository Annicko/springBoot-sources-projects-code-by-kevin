package com.iotknowyou.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return  new Queue("hello");
    }

    @Bean
    public Queue ObjQueue(){
        return  new Queue("Object");
    }
}
