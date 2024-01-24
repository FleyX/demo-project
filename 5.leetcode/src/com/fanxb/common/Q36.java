package com.fanxb.common;

import java.util.Arrays;

/**
 *
 */
public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[] check = new boolean[10];
        char c;
        for (int i = 0; i < 9; i++) {
            //检查行
            for (int j = 0; j < 9; j++) {
                c = board[i][j];
                if (c != '.') {
                    int num = c - '0';
                    if (check[num]) return false;
                    check[num] = true;
                }
            }
            Arrays.fill(check, false);
            //检查列
            for (int j = 0; j < 9; j++) {
                c = board[j][i];
                if (c != '.') {
                    int num = c - '0';
                    if (check[num]) return false;
                    check[num] = true;
                }
            }
            Arrays.fill(check, false);
            //检查小9宫格
            int starti = 3 * (i / 3), startj = (i % 3) * 3;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    c = board[starti + x][startj + y];
                    if (c != '.') {
                        int num = c - '0';
                        if (check[num]) return false;
                        check[num] = true;
                    }
                }
            }
            Arrays.fill(check, false);
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] chars =
                new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new Q36().isValidSudoku(chars));
    }
}
