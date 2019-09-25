package com.iotknowyou.HelloWorld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GetApplicationPropertiesData")
public class GetApplicationPropertiesData {
    /* 读取配置文件的数据 方法一 */
    @Value("${Kevin.name}")
    private String name;

    @Value("${Kevin.age}")
    private Integer age;

    @RequestMapping("/show")
    public String showData(){
        return "Kevin's name is  "+name+",age is " +age;
    }

    /* 读取配置文件的 方法二*/

    @Autowired
    private Environment environment;

    @RequestMapping("/showData")
    public String showDataByEnvironment(){
        String KevinName = environment.getProperty("Kevin.name");
        String Kevinage = environment.getProperty("Kevin.age");
        String res = "获得的数据：name: "+KevinName+",age: "+Kevinage;
        return res;
    }
}
