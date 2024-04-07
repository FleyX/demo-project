package com.fanxb.common.p100;

/**
 * 转移方程：dp[i]表示当以i为结尾时的最大子数组和
 * 当dp[i-1]>0时dp[i]=dp[i-1]+nums[i]
 * 否则dp[i]=nums[i]
 */
public class Q53 {
    public int maxSubArray(int[] nums) {

        int res = nums[0];
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newVal = last > 0 ? last + nums[i] : nums[i];
            res = Math.max(res, newVal);
            last = newVal;
        }
        return res;
    }
}
