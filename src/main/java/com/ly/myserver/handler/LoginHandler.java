package com.ly.myserver.handler;

import com.ly.MSG;
import com.ly.MainMessage;
import com.ly.core.MyMessage;

/**
 * @author: ly
 * @date: 2018/11/10 16:48:19
 * @description:
 */
public class LoginHandler extends BaseHandler{
    @Override
    public void handle(byte[] msg) {
        try {
            MainMessage.LoginRequest loginRequest = MainMessage.LoginRequest.parseFrom(msg);
            MainMessage.LoginResponse.Builder builder = MainMessage.LoginResponse.newBuilder();
            String username = loginRequest.getUsername();
            String password = loginRequest.getPassword();
            String tip = "";
            if("".equals(username) || "".equals(password)) {
                tip = "用户名或密码不能为空";
                builder.setCode(MSG.RCode.Fail);
                builder.setTip(tip);
                MyMessage rmsg = new MyMessage(MSG.MNUM.MLoginResponse.getNumber(), "",
                                                builder.build().toByteArray());
                send(rmsg);
                return;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
