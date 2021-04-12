package com.fanxb.common;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * x 的平方根
 * 地址： https://leetcode-cn.com/problems/sqrtx/
 * 思路：
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid]) {
                //无法分辨哪边是有序的
                l++;
                continue;
            }
            if (nums[l] < nums[mid]) {
                //说明[l,mid]是有序的
                if (nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //说明[mid,r]是有序的
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q81().search(new int[]{1,0,1,1,1}, 0));
    }
}
