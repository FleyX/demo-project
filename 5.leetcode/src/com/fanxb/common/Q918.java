package com.fanxb.common;

public class Q918 {
    public int maxSubarraySumCircular(int[] nums) {
        int total = nums[0], curMax = nums[0], totalMax = nums[0], curMin = nums[0], totalMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            totalMax = Math.max(curMax, totalMax);
            total += nums[i];
            curMin = Math.min(curMin + nums[i], nums[i]);
            totalMin = Math.min(curMin, totalMin);
        }
        return totalMax > 0 ? Math.max(totalMax, total - totalMin) : totalMax;
    }
}
