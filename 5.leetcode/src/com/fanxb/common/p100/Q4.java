package com.fanxb.common.p100;

/**
 * Created with IntelliJ IDEA
 * x 的平方根
 * 地址： https://leetcode-cn.com/problems/sqrtx/
 * 思路： 双路规避排序查找
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

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int mid1 = (m + n + 1) / 2, mid2 = (m + n + 2) / 2;
        return (findK(nums1, 0, m - 1, nums2, 0, n - 1, mid1) + findK(nums1, 0, m - 1, nums2, 0, n - 1, mid2)) / 2.0;
    }

    // 两个数组中找第k小的数
    private int findK(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2, int k) {
        int l1 = end1 - start1 + 1, l2 = end2 - start2 + 1;
        if (l1 == 0) return arr2[start2 + k - 1];
        if (l2 == 0) return arr1[start1 + k - 1];
        if (k == 1) return Math.min(arr1[start1], arr2[start2]);
        int index1 = start1 + Math.min(k / 2, l1) - 1;
        int index2 = start2 + Math.min(k / 2, l2) - 1;
        if (arr1[index1] >= arr2[index2])
            return findK(arr1, start1, end1, arr2, index2 + 1, end2, k - (index2 - start2 + 1));
        else
            return findK(arr1, index1 + 1, end1, arr2, start2, end2, k - (index1 - start1 + 1));
    }


    public static void main(String[] args) {
        System.out.println(new Q4().findMedianSortedArrays1(new int[]{1, 2}, new int[]{3, 4}));
    }
}
