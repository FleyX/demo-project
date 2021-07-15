package com.fanxb.common;

import java.util.Arrays;

/**
 * 题目地址： https://leetcode-cn.com/problems/partition-labels/
 * 解题思路：首先遍历一次字符串，记录每个字母最后出现的位置
 * 然后再遍历一遍，记录当前字符串的开始位置start,结束位置end. 当第i个字母的结束位置》end时end=第i个字母的结束位置，知道i=end说明当前位置为字符串的结束位置
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Q1846().maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));
    }
}
