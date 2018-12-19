package com.ly.myserver.event;

import com.ly.myserver.handler.BaseHandler;
import com.ly.myserver.handler.LoginHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ly
 * @date: 2018/11/10 16:48:19
 * @description:
 */
public class MappingManager {
    private static Map<Integer, Class<? extends BaseHandler>> map;

    static {
        map = new HashMap<>();
//        map.put(0, HeartHandler.class);
//        map.put(1, PeopleHandler.class);
        map.put(1000, LoginHandler.class);
//        map.put(1002, RegisterHandler.class);
    }

    public static Map get() {
        return map;
    }
}
