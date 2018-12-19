package com.ly.myserver.codec;

import com.ly.core.MyMessage;
import com.ly.util.AESUtil;
import com.ly.util.Util;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyEncoder extends MessageToByteEncoder<MyMessage>{
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MyMessage myMessage, ByteBuf byteBuf) throws Exception {
        byte[] sessionId = myMessage.getSessionIdByByte();
        byte[] body = AESUtil.encrypt(myMessage.getMsg());
        int length = body.length + 20;
        byteBuf.writeByte((byte)1);
        byteBuf.writeBytes(Util.intToByte(length));
        byteBuf.writeBytes(Util.intToByte(myMessage.getType()));
        byteBuf.writeBytes(sessionId);
        byteBuf.writeBytes(body);
    }
}
