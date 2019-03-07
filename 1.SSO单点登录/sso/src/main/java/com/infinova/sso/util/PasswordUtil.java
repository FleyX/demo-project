package com.infinova.sso.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/4 17:20
 */
public class PasswordUtil {
    /**
     * Description: plainText加salt使用sha1计算hash
     *
     * @param plainText 原文
     * @param salt      盐
     * @return byte[]
     * @author fanxb
     * @date 2019/3/4 17:20
     */
    private static byte[] computeHashValue(String plainText, byte[] salt) throws Exception {
        byte[] plainBytes = plainText.getBytes("utf-16LE");
        byte[] arr = new byte[salt.length + plainBytes.length];
        MessageDigest md = MessageDigest.getInstance("SHA1");
        ArrayUtil.copyTo(plainBytes, 0, arr, 0, plainBytes.length);
        ArrayUtil.copyTo(salt, 0, arr, plainBytes.length, salt.length);
        return md.digest(arr);
    }


    /**
     * Description: 根据原文计算出密文,计算方法：使用一个随机数做盐值和密码一起使用sha1做hash，再和盐值拼接到一起，
     * 最后生成base64字符串
     *
     * @param pass 原文
     * @return java.lang.String
     * @author fanxb
     * @date 2019/3/4 17:21
     */
    public static String createPassword(String pass) throws Exception {
        byte[] salt = SecureRandom.getSeed(0x10);
        byte[] buffer2 = computeHashValue(pass, salt);
        byte[] array = new byte[0x24];
        ArrayUtil.copyTo(salt, 0, array, 0, salt.length);
        ArrayUtil.copyTo(buffer2, 0, array, salt.length, salt.length);
        return DatatypeConverter.printBase64Binary(array);
    }

    /**
     * Description: 判断密文原文是否一致
     *
     * @param cipherPassword 密文
     * @param plainPassword  原文
     * @return boolean
     * @author fanxb
     * @date 2019/3/4 17:23
     */
    public static boolean checkPassword(String cipherPassword, String plainPassword) {
        try {
            byte[] cipherPasswordBytes = DatatypeConverter.parseBase64Binary(cipherPassword);
            byte[] saltBytes = new byte[0x10];
            ArrayUtil.copyTo(cipherPasswordBytes, 0, saltBytes, 0, saltBytes.length);
            byte[] passwordBytes = computeHashValue(plainPassword, saltBytes);
            byte[] realPasswordBytes = new byte[20];
            ArrayUtil.copyTo(cipherPasswordBytes, saltBytes.length, realPasswordBytes, 0, realPasswordBytes.length);
            for (int i = 0; i < realPasswordBytes.length; i++) {
                if (passwordBytes[i] != realPasswordBytes[i]) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
