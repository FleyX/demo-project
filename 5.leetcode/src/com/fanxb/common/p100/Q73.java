package com.fanxb.common.p100;


public class Q73 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //行是否有0
        int[] cache1 = new int[m];
        //列是否有0
        int[] cache2 = new int[n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0) {
                    cache1[i] = 1;
                    cache2[j] = 1;
                }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (cache1[i] == 1 || cache2[j] == 1)
                    matrix[i][j] = 0;
    }

    public static void main(String[] args) {
    }
}
