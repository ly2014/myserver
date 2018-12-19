package com.ly.myserver.session;

import com.ly.myserver.model.User;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ying
 * @date 2018-12-19 11:33
 */
public class Session {
    private static final Logger log = LoggerFactory.getLogger(Session.class);

    private final Channel channel;

    private final long createTime;

    private User user;

    protected Session(Channel channel) {
        this.channel = channel;
        this.createTime = System.currentTimeMillis();
    }

    void bind(User user) {
        this.user = user;
    }

    Channel getChannel() {
        return channel;
    }

    long getCreateTime() {
        return createTime;
    }

    User getUser() {
        return user;
    }

    void close() {
        if (channel == null) {
            return;
        }
        try {
            if (channel.isActive() || channel.isOpen()) {
                channel.close().sync();
            }
        }catch (InterruptedException e) {
            log.error("close channel error", e);
        }
    }
}
