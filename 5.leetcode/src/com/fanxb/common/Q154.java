package com.fanxb.common;

/**
 * Created with IntelliJ IDEA
 * 寻找旋转排序数组中的最小值 II
 * 地址： https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 思路： 部分二分查找法，当知道某一段是有序的时候就能够快速判断出这一段的最小值
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q154 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[l] == nums[mid]) {
                //无法判断哪边是有序的
                if (nums[l] < min) {
                    min = nums[mid];
                }
                l++;
            } else if (nums[l] < nums[mid]) {
                //左边是有序的,找到了左边的最小值
                if (nums[l] < min) {
                    min = nums[l];
                }
                l = mid + 1;
            } else {
                //右边是有续的，找到了右边的最小值
                if (nums[mid] < min) {
                    min = nums[mid];
                }
                r = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Q154().findMin(new int[]{1, 0, 1, 1, 1}));
    }
}
