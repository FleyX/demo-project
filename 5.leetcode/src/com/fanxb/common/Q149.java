package com.fanxb.common;

/**
 * Created with IntelliJ IDEA
 * 寻找旋转排序数组中的最小值
 * 地址： https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 思路： 需要找到分界点
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q149 {
    public int maxPoints(int[][] points) {
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            int[] a1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] a2 = points[j];
                int n = 2;
                for (int k = j + 1; k < points.length; k++) {
                    int[] a3 = points[k];
                    if ((a2[1] - a1[1]) * (a3[0] - a1[0]) == (a3[1] - a1[1]) * (a2[0] - a1[0])) {
                        n++;
                    }
                }
                if (n > max) {
                    max = n;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q149().maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }
}
