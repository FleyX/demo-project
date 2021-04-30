package com.fanxb.common;

import java.util.Arrays;

/**
 * 旋转链表
 * 题目地址：https://leetcode-cn.com/problems/assign-cookies/submissions/
 * 解题思路：
 * 贪心算法，想不明白
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q213 {

    public int rob(int[] nums) {
        int last = 0, cur = 0;
        for (int num : nums) {
            int temp = cur;
            cur = Math.max(cur, last + num);
            last = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 3, 1};
        System.out.println(new Q213().rob(s));
    }
}
