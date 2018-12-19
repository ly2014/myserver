package com.ly.myserver.service;

import org.springframework.context.ApplicationContext;

/**
 * @author ying
 * @date 2018-12-18 20:40
 */
public class ServiceManager {
    private static ApplicationContext context;

    public static void setApplicationContext(ApplicationContext context) {
        ServiceManager.context = context;
    }

    private static UserService userService = null;

    public static UserService getUserService() {
        if (userService == null) {
            userService = (UserService)context.getBean("userService");
        }
        return userService;
    }
}
