package com.ly.myserver.codec;

import com.ly.myserver.core.MyMessage;
import com.ly.myserver.util.AESUtil;
import com.ly.myserver.util.Util;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
/**
 * @author ying
 * @date 2018-12-19 10:00
 */
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
