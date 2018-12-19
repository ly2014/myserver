package com.ly.myserver.test;

import com.ly.myserver.MSG;
import com.ly.myserver.MainMessage;
import com.ly.myserver.core.MyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("Client active");
        MainMessage.LoginRequest.Builder builder = MainMessage.LoginRequest.newBuilder();
        builder.setUsername("xyz");
        builder.setPassword("123");
        builder.setType(MSG.MNUM.MLoginRequest);
        MyMessage mg = new MyMessage(MSG.MNUM.MLoginRequest.getNumber(), "", builder.build().toByteArray());
        ctx.writeAndFlush(mg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        System.out.println(msg);
    }
}
