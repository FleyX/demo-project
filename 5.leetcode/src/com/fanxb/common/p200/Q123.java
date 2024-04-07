package com.fanxb.common.p200;

/**
 * 题目地址： https://leetcode-cn.com/problems/partition-labels/
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q123 {

    public static int solution(int[] prices) {
        int res = 0;
        int start = -1;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i] && start == -1) {
                //说明是首次上坡
                start = prices[i];
            } else if (prices[i + 1] < prices[i] && start != -1) {
                res += prices[i] - start;
                start = -1;
            }
        }
        //判断最后一个能不能卖
        if (start != -1 && prices[prices.length - 1] > start) {
            res += prices[prices.length - 1] - start;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution(prices));
    }
}
