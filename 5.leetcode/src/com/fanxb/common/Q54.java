package com.fanxb.common;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        list.add(matrix[0][0]);
        int i = 0, j = 0, count = 1, m = matrix.length, n = matrix[0].length;
        int type = 0;
        matrix[0][0] = -200;
        while (count < m * n) {
            switch (type) {
                //向右走
                case 0:
                    if (j + 1 >= n || matrix[i][j + 1] == -200) {
                        type = 1;
                        continue;
                    } else j++;
                    break;
                //向下
                case 1:
                    if (i + 1 >= m || matrix[i + 1][j] == -200) {
                        type = 2;
                        continue;
                    } else i++;
                    break;
                //向左
                case 2:
                    if (j - 1 == -1 || matrix[i][j - 1] == -200) {
                        type = 3;
                        continue;
                    } else j--;
                    break;
                //向上
                case 3:
                    if (i - 1 == -1 || matrix[i - 1][j] == -200) {
                        type = 0;
                        continue;
                    } else i--;
                    break;
            }
            list.add(matrix[i][j]);
            matrix[i][j] = -200;
            count++;
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.printf(new Q54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).toString());
    }
}
