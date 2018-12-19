package com.ly.myserver;

import com.ly.myserver.core.NettyServer;
import com.ly.myserver.model.User;
import com.ly.myserver.service.ServiceManager;
import com.ly.myserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyserverApplication {
    private static Logger logger = LoggerFactory.getLogger(MyserverApplication.class);

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(MyserverApplication.class, args);
        ServiceManager.setApplicationContext(ac);
        NettyServer server = ac.getBean(NettyServer.class);
        server.run();
        System.out.println("service run");
    }

}