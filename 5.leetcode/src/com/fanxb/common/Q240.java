package com.fanxb.common;

/**
 * @author fanxb
 * @date 2021-10-25-下午4:25
 */
public class Q240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (matrix[m - 1][n - 1] < target || matrix[0][0] > target) {
            return false;
        }
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] params = {{-1, 3}};
        System.out.println(new Q240().searchMatrix(params, 1));
    }
}
