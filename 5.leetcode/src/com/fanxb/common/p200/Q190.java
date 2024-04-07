package com.fanxb.common.p200;

/**
 * 具有给定数值的最小字符串
 * <p>
 * 题目地址：https://leetcode-cn.com/problems/reverse-bits
 * <p>
 * 解题思路：简单的位运算
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q190 {

    public static int solution(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++, n = n >>> 1) {
            res = res << 1 | (n & 1);
            System.out.println(Integer.toBinaryString(res));
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 43261596;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(solution(num));
    }
}
