package com.iotknowyou.ThymeleafTest.service.Impl;

import com.iotknowyou.ThymeleafTest.entity.User;
import com.iotknowyou.ThymeleafTest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> allUser() {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User("Liu_"+i,String.valueOf(22 + i));
            userList.add(user);
        }
        return userList;
    }
}
