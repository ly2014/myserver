package com.ly.myserver.core;

import com.ly.myserver.event.DispatchMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author ying
 * @date 2018-12-19 10:00
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("Server channel active");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        MyMessage message = (MyMessage)msg;
        DispatchMessage.dispatch(message, ctx.channel());
        System.out.println("Server channel read");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        System.out.println(cause);
    }
}
