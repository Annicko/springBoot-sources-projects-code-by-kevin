package com.iotknowyou.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitMQConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage(){
        return new Queue(TopicRabbitMQConfig.message);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(TopicRabbitMQConfig.messages);
    }


    //创建交换机
    @Bean
    TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }


    @Bean
    Binding bindingExchangeMessage(Queue queueMessage , TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages , TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessages).to(topicExchange).with("topic.#");
    }
}
