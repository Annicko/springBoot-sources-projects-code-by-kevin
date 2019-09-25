package com.iotknowyou.HelloWorld.controller;

import com.iotknowyou.HelloWorld.service.HelloServiceInputByXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private HelloServiceInputByXML helloServiceInputByXML;

    @RequestMapping("/hello")
    public String Hello(){
        helloServiceInputByXML.PrintString();
        return "Hello world !";
    }
}
