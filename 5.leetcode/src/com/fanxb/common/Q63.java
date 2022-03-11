package com.fanxb.common;

import java.util.Arrays;

/**
 * TODO
 *
 * @author fanxb
 * @date 2022/3/11 15:28
 */
public class Q63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Q63().uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }
}
