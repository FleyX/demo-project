package com.fanxb.common.p100;

import java.util.Arrays;


public class Q48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            int length1 = length - i * 2;
            for (int j = 0; j < length1-1; j++) {
                int temp = matrix[i + j][i + length1 - 1];
                matrix[i + j][i + length1 - 1] = matrix[i][i + j];
                int temp1 = matrix[i + length1 - 1][i + length1 - 1 - j];
                matrix[i + length1 - 1][i + length1 - 1 - j] = temp;
                temp = matrix[i+length1-1-j][i];
                matrix[i+length1-1-j][i] = temp1;
                matrix[i][i + j] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        Q48 ins = new Q48();
        ins.rotate(arr);
        for (int[] temp : arr) {
            System.out.println(Arrays.toString(temp));
        }
    }
}
