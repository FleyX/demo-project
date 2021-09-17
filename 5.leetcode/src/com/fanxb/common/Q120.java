package com.fanxb.common;

import java.util.Arrays;
import java.util.List;

/**
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int lineNum = triangle.size();
        int[][] dp = new int[lineNum][triangle.get(lineNum - 1).size()];
        for (int i = 0; i < lineNum; i++) {
            List<Integer> line = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                if (i == 0) {
                    dp[i][j] = line.get(j);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + line.get(j);
                } else if (j == line.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + line.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + line.get(j);
                }
            }
        }
        int min = dp[lineNum - 1][0];
        for (int i = 1; i < lineNum; i++) {
            if (dp[lineNum - 1][i] < min) {
                min = dp[lineNum - 1][i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3, 4);
        List<Integer> l3 = Arrays.asList(6, 5, 7);
        List<Integer> l4 = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> l5 = Arrays.asList(Arrays.asList(-10));
        System.out.println(new Q120().minimumTotal(l5));
    }
}
