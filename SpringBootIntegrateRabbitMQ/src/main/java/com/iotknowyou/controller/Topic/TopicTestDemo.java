package com.iotknowyou.controller.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Topic")
public class TopicTestDemo {

    @Autowired
    private TopicSender topicSender;

    @GetMapping("/TopicTestSendMsg")
    @ResponseBody
    public String TopicTestSendMsq(){
        topicSender.send_0();
        topicSender.send_1();
        topicSender.send_2();
        return "success";
    }
}
