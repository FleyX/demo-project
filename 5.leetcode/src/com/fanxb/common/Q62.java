package com.fanxb.common;

import java.util.Arrays;

/**
 * TODO
 *
 * @author fanxb
 * @date 2022/3/11 15:28
 */
public class Q62 {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        Arrays.fill(f[0], 1);
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Q62().uniquePaths(3, 7));
    }
}
