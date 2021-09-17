package com.fanxb.common;

import java.util.Stack;

/**
 * 定义dp[i]为以nums[i]结尾的子序列最大长度
 *
 * @author fanxb
 * @date 2021-08-31-下午11:15
 */
public class Q300 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length, res = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q300().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
