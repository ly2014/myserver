package com.ly.myserver.event;

import com.ly.myserver.core.MyMessage;
import com.ly.myserver.util.AESUtil;
import io.netty.channel.Channel;

import java.lang.reflect.Method;

public class DispatchMessage {
    public static void dispatch(MyMessage message, Channel channel) {
        try {
            Class cls = (Class) MappingManager.get().get(message.getType());
            Method md1 = cls.getMethod("setChannel", Channel.class);
            Method md2 = cls.getMethod("setSessionId", String.class);
            Method md3 = cls.getMethod("handle", byte[].class);
            Object obj = cls.newInstance();
            md1.invoke(obj, channel);
            md2.invoke(obj, message.getSessionId());
            md3.invoke(obj, AESUtil.decrypt(message.getMsg()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}