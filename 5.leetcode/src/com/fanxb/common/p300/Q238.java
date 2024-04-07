package com.fanxb.common.p300;

import java.util.Arrays;

public class Q238 {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if (length <= 1) return nums;
        int[] left = new int[length];
        left[0] = nums[0];
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        int[] right = new int[length];
        right[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        for (int i = 1; i < length - 1; i++) {
            nums[i] = left[i - 1] * right[i + 1];
        }
        nums[0] = right[1];
        nums[length - 1] = left[length - 2];
        return nums;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q238().productExceptSelf(new int[]{1, 0})));
    }
}
