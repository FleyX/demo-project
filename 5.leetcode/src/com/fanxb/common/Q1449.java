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
public class Q1449 {
    public String largestNumber(int[] cost, int target) {
        int[] f = new int[target + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        f[0] = 0;
        for (int i = 1; i <= 9; i++) {
            int u = cost[i - 1];
            for (int j = u; j <= target; j++) {
                f[j] = Math.max(f[j], f[j - u] + 1);
            }
        }
        if (f[target] < 0) return "0";
        StringBuilder ans = new StringBuilder();
        for (int i = 9, j = target; i >= 1; i--) {
            int u = cost[i - 1];
            while (j >= u && f[j] == f[j - u] + 1) {
                ans.append(i);
                j -= u;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q1449().largestNumber(new int[]{4,3,2,5,6,7,2,5,5},9));
    }
}
