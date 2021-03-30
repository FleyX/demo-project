package com.fanxb.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 题目地址： https://leetcode-cn.com/problems/partition-labels/
 * 解题思路：首先遍历一次字符串，记录每个字母最后出现的位置
 * 然后再遍历一遍，记录当前字符串的开始位置start,结束位置end. 当第i个字母的结束位置》end时end=第i个字母的结束位置，知道i=end说明当前位置为字符串的结束位置
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q122 {

    public static int solution(int[] prices) {
        int res = 0;
        int start = -1, end = -1;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                //说明是上坡
                if (start == -1) {
                    start = prices[i];
                }
                end = prices[i + 1];
            } else if (prices[i + 1] < prices[i]) {
                //说明开始下坡了
                if (end > start) {
                    res += end - start;
                }
                start = -1;
                end = -1;
            }
        }
        if (end > start) {
            res += end - start;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution(prices));
    }
}
