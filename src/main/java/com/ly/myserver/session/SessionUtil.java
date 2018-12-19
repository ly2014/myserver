package com.ly.myserver.session;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

/**
 * @author ying
 * @date 2018-12-19 15:23
 */
public class SessionUtil {
    public static final AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

    public static <T> T getAttribute(Channel channel, AttributeKey<T> key) {
        return channel.attr(key).get();
    }

    public static <T> void setAttribute(Channel channel, AttributeKey<T> key, T value) {
        channel.attr(key).set(value);
    }
}
