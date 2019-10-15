package com.iotknowyou.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {
    @Bean(name="AMessage")
    public Queue AMessage(){
        return new Queue("FanoutA");
    }

    @Bean(name="BMessage")
    public Queue BMessage(){
        return new Queue("FanoutB");
    }

    @Bean(name="CMessage")
    public Queue CMessage(){
        return new Queue("FanoutC");
    }

    //创建交换机
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeMessageA (@Qualifier("AMessage")Queue AMessage , FanoutExchange fanoutExchange){
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeMessageB (@Qualifier("BMessage")Queue BMessage , FanoutExchange fanoutExchange){
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeMessageC (@Qualifier("CMessage")Queue CMessage , FanoutExchange fanoutExchange){
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
