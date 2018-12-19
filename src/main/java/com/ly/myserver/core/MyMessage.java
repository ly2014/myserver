package com.ly.myserver.core;

/**
 * @author ying
 * @date 2018-12-19 10:00
 */
public class MyMessage{
    private int type;

    private String sessionId;

    private byte[] msg;

    public MyMessage(int type, String sessionId, byte[] msg) {
        this.type = type;
        this.sessionId = sessionId;
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public byte[] getMsg() {
        return msg;
    }

    public String getSessionId() {
        return sessionId;
    }

    public byte[] getSessionIdByByte() {
        byte[] rs = new byte[16];
        byte[] sid = sessionId.getBytes();
        for(int i = 0 ; i < sid.length; i++) {
            rs[i] = sid[i];
        }
        return rs;
    }

}
