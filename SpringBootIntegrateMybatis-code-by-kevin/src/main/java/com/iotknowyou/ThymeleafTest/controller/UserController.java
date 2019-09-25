package com.iotknowyou.ThymeleafTest.controller;

import com.iotknowyou.ThymeleafTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/allUser",method = RequestMethod.GET)

    public String all(ModelMap model){
        model.addAttribute("users",userService.allUser());
        return "userPages";
       /* model.addAttribute("name","LiuRongHua");
        return "userPages";*/
    }

}
