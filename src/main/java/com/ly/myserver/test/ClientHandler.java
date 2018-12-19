package com.ly.myserver.test;

import com.ly.core.MyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("Client active");
        People.Person.Builder builder = People.Person.newBuilder();
        builder.setAge(10);
        builder.setName("ly");
        builder.setType(People.Msg.PersonMsg);
        MyMessage mg = new MyMessage(People.Msg.PersonMsg.getNumber(), "", builder.build().toByteArray());
        ctx.writeAndFlush(mg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        System.out.println(msg);
    }
}
