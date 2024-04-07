package com.fanxb.common.p300;

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
        if (nums.length == 1) {
            return nums[0];
        } else {
            return Math.max(robDo(Arrays.copyOfRange(nums, 0, nums.length - 1)), robDo(Arrays.copyOfRange(nums, 1, nums.length)));
        }
    }

    private int robDo(int[] nums) {
        //定义fn[k]表示有k个房子时的最大金额
        int[] fn = new int[nums.length + 1];
        //显然fn[0]=0,fn[1]=nums[0]
        fn[1] = nums[0];
        int res = fn[1];
        for (int i = 2; i <= nums.length; i++) {
            //当发现新房子时要获得最大收益有两种选择，偷这个新房子（不能偷前一个房子）或者不偷这一个房子（这样就能偷前一个房子了）,这两个情况用公式表示如下：
            fn[i] = Math.max(fn[i - 1], fn[i - 2] + nums[i - 1]);
            if (fn[i] > res) {
                res = fn[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 3, 1};
        System.out.println(new Q213().rob(s));
    }
}
