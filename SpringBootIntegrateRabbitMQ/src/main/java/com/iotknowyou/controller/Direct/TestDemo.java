package com.iotknowyou.controller.Direct;

import com.iotknowyou.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/*
    消息中间件： 分布式系统中完成消息的发送的接收的基本软件
    消息中间件的工作过程：类比成：生产者不断地向消息队列发送消息，而消费者从消息队列中消费消息

    RabbitMQ中，除去（生产者 ， 消息队列 ，消费者）三个基本的模块外，还添加了一个模块，交换机。

    交换机的作用：接收相应的消息，并且绑定到指定的队列。
        交换机有四种类型：
            Driect : RabbitMQ默认的交换机模式。在创建消息队列的时候，指定一个 BindingKey 。
            当发送者发送消息的时候，指定对应的Key。当Key 和 消息队列的BindingKey一致的时候，
            消息将会被发送到该消息队列中

            Topic ：转发信息主要是依据通配符，队列和交换机的绑定主要依据一种模式（ 通配符 + 字符串 ），
                   而当发送消息的时候，只有指定的Key和该模式相匹配的时候消息才会被发送到该消息队列中

            headers ： 根据一个规则进行匹配，在消息队列和交换机绑定的时候会指定一组键值对规则，
            而发送消息的时候也会指定一组键值对规则，当两组键值对规则匹配的时候，消息会被发送到匹配的消息队列中

            Fanout ： 路由广播的形式，将会把消息发给绑定它的全部队列，即便设置了Key，也会被忽略。

*/

@Controller
@RequestMapping("/Direct")
public class TestDemo {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private ModelSender modelSender;

    @GetMapping("/TestSendMsq")
    @ResponseBody
    public String TestSendMsg(){
        for (int i = 0; i < 10; i++) {
            helloSender.sendMsg(i);
        }
        return "success";
    }

    @GetMapping("/TestSendObjMsq")
    @ResponseBody
    public String TestSendObjMsq(){
        for (int i = 0; i < 10; i++) {
            Person person = new Person("liu",i,i);
            modelSender.sendMsg(person);
        }
        return "success";
    }
}
