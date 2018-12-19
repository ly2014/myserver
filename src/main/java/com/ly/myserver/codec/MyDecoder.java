package com.ly.myserver.codec;

import com.ly.core.MyMessage;
import com.ly.util.MappingManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.lang.reflect.Method;
import java.util.List;

public class MyDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        while (byteBuf.readableBytes() > 5) {
            byteBuf.markReaderIndex();

            byte flag = byteBuf.readByte();
            if(flag != (byte)1) {
                return;
            }

            int length = byteBuf.readInt();

            if(byteBuf.readableBytes() < length) {
                byteBuf.resetReaderIndex();
                return;
            }

            int type = byteBuf.readInt();

            byte[] sessionByte = new byte[16];
            byteBuf.readBytes(sessionByte);
            String sessionId = new String(sessionByte);

            int bodyLength = length - 20;
            byte[] body = new byte[bodyLength];
            byteBuf.readBytes(body);
            MyMessage msg = new MyMessage(type, sessionId, body);
            list.add(msg);

        }
    }
}
