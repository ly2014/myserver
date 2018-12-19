package com.ly.myserver.handler;

import com.ly.myserver.core.MyMessage;
import io.netty.channel.Channel;

/**
 * @author: ly
 * @date: 2018/11/10 16:48:19
 * @description:
 */
public abstract class BaseHandler {
    private Channel channel;

    private String sessionId;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * 用以处理网络中接收到的消息
     * @param msg 消息的二进制数组
     */
    public abstract void handle(byte[] msg);

    public void send(MyMessage msg) {
        channel.writeAndFlush(msg);
    }
}
