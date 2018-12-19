package com.ly.myserver.util;

import java.util.UUID;

public class Util {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").substring(8, 24);
    }

    public static byte[] intToByte(int value) {
        byte[] src = new byte[4];
        src[0] = (byte) ((value >> 24) & 0xFF);
        src[1] = (byte) ((value >> 16) & 0xFF);
        src[2] = (byte) ((value >> 8) & 0xFF);
        src[3] = (byte) (value & 0xFF);
        return src;
    }
}
