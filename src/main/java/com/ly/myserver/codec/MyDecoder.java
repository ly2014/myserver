package com.ly.myserver.codec;

import com.ly.myserver.core.MyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;
/**
 * @author ying
 * @date 2018-12-19 10:00
 */
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
