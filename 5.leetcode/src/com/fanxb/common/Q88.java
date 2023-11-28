package com.fanxb.common;

import java.util.Arrays;
import java.util.Collections;

/**
 * 合并两个有序数组
 * 题目地址：https://leetcode-cn.com/problems/merge-sorted-array/
 * 解题思路：
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q88 {

    public static void solution(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[nums1.length];
        int i = 0, j = 0;
        int count = 0;
        while (count < m + n) {
            if (i == m) {
                res[count++] = nums2[j++];
            } else if (j == n) {
                res[count++] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                res[count++] = nums1[i++];
            } else {
                res[count++] = nums2[j++];
            }
        }
        System.arraycopy(res, 0, nums1, 0, count);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        for (int i = 0, j = 0, k = 0; k < m + n; k++) {
            
        }

    }


    public static void main(String[] args) {
        int[] nums1 = new int[12];
        System.out.println(Arrays.toString(nums1));
    }
}
