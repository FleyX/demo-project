package com.infinova.sso.util;

/**
 * 类功能简述： 数组工具类
 *
 * @author fanxb
 * @date 2019/3/4 17:06
 */
public class ArrayUtil {
    /**
     * Description: 从指定数组指定下标复制指定长度到目标数组指定下标
     *
     * @author fanxb
     * @date 2019/3/4 17:16
     * @param source 源数组
     * @param sourceStart 原数组copy开始下标
     * @param target 目标数组
     * @param targetStart 目标数组接收开始下标
     * @param length copy长度
     */
    public static void copyTo(byte[] source, int sourceStart, byte[] target, int targetStart, int length) {
        for (int i = 0; i < length; i++) {
            target[targetStart + i] = source[sourceStart + i];
        }
    }
}
