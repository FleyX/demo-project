package com.fanxb.common;

import java.util.Arrays;

/**
 * 具有给定数值的最小字符串
 * 题目地址： https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 解题思路：两次二分即可，第一次二分列找到所在行，然后二分所在行找到是否存在目标值（由于行列数少于100,直接搜索问题也不大）
 *
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q74 {

    public static boolean solution(int[][] matrix, int target) {
        //m行数，n列数
        int m = matrix.length, n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) {
            return false;
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] > target) {
                return Arrays.stream(matrix[i - 1]).anyMatch(item -> item == target);
            }
        }
        return Arrays.stream(matrix[m - 1]).anyMatch(item -> item == target);
    }

    public static void main(String[] args) {
        int[][] s = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 6}};
        System.out.println(solution(s, 3));
    }
}
