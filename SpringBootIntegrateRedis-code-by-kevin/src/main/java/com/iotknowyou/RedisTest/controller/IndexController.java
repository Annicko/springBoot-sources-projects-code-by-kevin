package com.iotknowyou.RedisTest.controller;

import com.iotknowyou.RedisTest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;

@Controller
public class IndexController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String , Serializable> redisTemplate;

    @RequestMapping(value = "/redisTest",method = RequestMethod.GET)
    public String getAllStudents(Model model){
        Student student = new Student(10,"LiuRongHua_20190922",23,"NO0012");
        String strKey = "stringStudent";
        stringRedisTemplate.opsForValue().set(strKey,student.toString());
        final String valueStr = stringRedisTemplate.opsForValue().get(strKey);
        model.addAttribute(strKey,valueStr);
        String objkey = "stringObj";
        redisTemplate.opsForValue().set(objkey,student);
        student = (Student) redisTemplate.opsForValue().get(objkey);
        model.addAttribute(objkey,student);
        return "RedisTest/index";
    }
}
