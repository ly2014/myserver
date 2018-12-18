package com.ly.myserver;

import com.ly.myserver.model.User;
import com.ly.myserver.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyserverApplication {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(MyserverApplication.class, args);
        UserService us = (UserService)ac.getBean("userService");
        User user = us.getUserByUsername("ly");
        System.out.println(user.getPassword());
    }

}