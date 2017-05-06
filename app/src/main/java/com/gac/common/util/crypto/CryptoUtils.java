package com.gac.common.util.crypto;


import com.gac.common.constants.Constants;

import java.security.MessageDigest;

public class CryptoUtils {

    /**
     * 使用AES加密字符串
     */
    public static String encryptByAES(String src) throws Exception {
        return AESUtils.encrypt(Constants.Others.SEED, src);
    }

    /**
     * 使用AES解密字符串
     */
    public static String decryptByAES(String src) throws Exception {
        return AESUtils.decrypt(Constants.Others.SEED, src);
    }

    /**
     * 使用MD5加密字符串
     */
    public static String encryptByMD5(String s) throws Exception {
        byte[] hash = MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"));
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}
