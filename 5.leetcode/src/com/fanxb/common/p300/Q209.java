package com.fanxb.common.p300;

import java.util.Arrays;

public class Q209 {

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE, l = 0, r = 0;
        int sum = 0;
        while (r < nums.length) {
            //循环添加右边的元素到窗口中
            sum += nums[r];
            //如果和大于target了，就开始减掉左边的元素，并计算最小值
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 3, 1};
    }
}
