package com.ly.myserver.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtil {
    private static final String KEY = "poker";

    /**
     * AES加密或解密字节数组
     * @param mode 加密或者解密
     * @param content 需要加解密的字节数组
     * @return 加解密后的字节数组
     */
    private static byte[] aes(int mode, byte[] content) {
        try {
            //构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //根据ecnodeRules规则初始化密钥生成器,生成一个128位的随机源,根据传入的字节数组
            kgen.init(128, new SecureRandom(KEY.getBytes()));
            //产生原始对称密钥
            SecretKey secretKey = kgen.generateKey();
            //获得原始对称密钥的字节数组
            byte[] enCodeFormat = secretKey.getEncoded();
            //根据字节数组生成AES密钥
            SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
            //创建密码器
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, keySpec);
            byte[] result = cipher.doFinal(content);
            return result;
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }catch (InvalidKeyException e) {
            e.printStackTrace();
        }catch (BadPaddingException e) {
            e.printStackTrace();
        }catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES加密
     * @param content 需要加密的字节数组
     * @return 加密后的字节数组
     */
    public static byte[] encrypt(byte[] content) {
        return aes(Cipher.ENCRYPT_MODE, content);
    }

    /**
     * AES解密
     * @param content 需要解密的字节数组
     * @return 解密后的字节数组
     */
    public static byte[] decrypt(byte[] content) {
        return aes(Cipher.DECRYPT_MODE, content);
    }
}
