package com.offcn.controller;

import com.offcn.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/add")
    public User add(User user){

        return user;
    }

    @RequestMapping("/add2")
    public User add2(@RequestBody User user){

        return user;
    }
}