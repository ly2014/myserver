package com.ly.myserver.session;

import io.netty.util.AttributeKey;

/**
 * @author ying
 * @date 2018-12-19 15:23
 */
public class SessionAttributeKey {
    public static final AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
