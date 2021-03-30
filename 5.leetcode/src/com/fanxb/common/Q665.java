package com.fanxb.common;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 题目地址：https://leetcode-cn.com/problems/non-decreasing-array/submissions/
 * 解题思路：贪心算法，遍历数组，每次调整都要尽量用最小的值
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q665 {


    public static boolean betterSolution(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        //是否首次调整
        boolean firstAdjust = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i == 0) {
                    //首个节点就不满足只能让nums[0]=nums[1]一种调整办法
                    firstAdjust = false;
                    nums[0] = nums[1];
                } else {
                    //不为首个节点
                    if (!firstAdjust) {
                        return false;
                    }
                    if (nums[i + 1] < nums[i - 1]) {
                        //如果i+1的值小于i-1的值只能将i+1的值调大
                        nums[i + 1] = nums[i];
                    } else {
                        //否则将nums[i]调小是最好的
                        nums[i] = nums[i - 1];
                    }
                    firstAdjust = false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 4, 2, 3};
        System.out.println(betterSolution(nums));
    }
}
