package com.ly.myserver.session;

import com.ly.myserver.model.User;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author ying
 * @date 2018-12-19 11:45
 */
public class SessionManager {
    private static final Logger log = LoggerFactory.getLogger(SessionManager.class);

    private static SessionManager instance = null;

    private SessionManager() {

    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private final ConcurrentMap<String, Session> sessionMap = new ConcurrentHashMap<>();

    public Session getSession(String uid) {
        return sessionMap.get(uid);
    }


    public Session getSessionByChannel(Channel channel) {
        return SessionUtil.getAttribute(channel, SessionUtil.SESSION);
    }

    public Session createSession(Channel channel) {
        Session session = getSessionByChannel(channel);
        if (session == null) {
            session = new Session(channel);
            SessionUtil.setAttribute(channel, SessionUtil.SESSION, session);
            log.info("创建session成功");
        } else {
            log.info("新连接创建时，session已存在");
        }
        return session;
    }

    public void bindUser(Session session, User user) {
        session.bind(user);
        sessionMap.put(user.getUnum(), session);
    }

    public void closeChannel(Channel channel) {
        Session session = getSessionByChannel(channel);
        if (session != null) {
            SessionUtil.setAttribute(channel, SessionUtil.SESSION, null);

            User user = session.getUser();
            if (user != null) {
                sessionMap.remove(user.getUnum());
                log.info("用户注销session，用户编号为：{}", user.getUnum());
            }
            session.close();
        }
    }
}
