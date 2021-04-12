package com.fanxb.common;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * x 的平方根
 * 地址： https://leetcode-cn.com/problems/sqrtx/
 * 思路： 双路规避排序查找
 *
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        boolean isDoubleSize = (size & 1) == 0;
        if (nums1.length == 0) {
            return nums2.length == 1 ? nums2[0] : isDoubleSize ? (nums2[size / 2 - 1] + nums2[size / 2]) / 2.0 : nums2[size / 2];
        } else if (nums2.length == 0) {
            return nums1.length == 1 ? nums1[0] : isDoubleSize ? (nums1[size / 2 - 1] + nums1[size / 2]) / 2.0 : nums1[size / 2];
        }

        //二路归并找到中间两个位置的数
        int count = 0, i = 0, j = 0, value = 0;
        while (count < size / 2) {
            if (i == nums1.length) {
                value = nums2[j++];
            } else if (j == nums2.length) {
                value = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                value = nums1[i++];
            } else {
                value = nums2[j++];
            }
            count++;
        }
        int value2 = i == nums1.length ? nums2[j] : j == nums2.length ? nums1[i] : Math.min(nums1[i], nums2[j]);
        return isDoubleSize ? (value + value2) / 2.0 : value2;
    }

    public static void main(String[] args) {
        System.out.println(new Q4().findMedianSortedArrays(new int[]{2,3,4}, new int[]{1}));
    }
}
