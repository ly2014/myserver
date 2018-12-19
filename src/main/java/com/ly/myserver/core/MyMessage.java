package com.ly.myserver.main;

/**
 * @author: ly
 * @date: 2018/11/10 16:48:19
 * @description:
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
