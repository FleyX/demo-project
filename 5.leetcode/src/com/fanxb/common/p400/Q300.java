package com.fanxb.common.p400;

import java.util.Arrays;

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

    public int another(int[] nums) {
        int n = nums.length, res = 1;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int better(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int l = 0, r = res;
            while (l < r) {
                int m = (l + r) / 2;
                if (tails[m] < num) l = m + 1;
                else r = m;
            }
            if (l == res) res++;
        }
        return res;
    }

    public int bad(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Q300().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(new Q300().another(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
