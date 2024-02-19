package com.fanxb.common;


public class Q150 {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int aliveCount = 0;
                if (i > 0 && j > 0 && board[i - 1][j - 1] >= 1) aliveCount++;
                if (i > 0 && board[i - 1][j] >= 1) aliveCount++;
                if (i > 0 && j < n - 1 && board[i - 1][j + 1] >= 1) aliveCount++;
                if (j > 0 && board[i][j - 1] >= 1) aliveCount++;
                if (j < m - 1 && board[i][j + 1] >= 1) aliveCount++;
                if (i < m - 1 && j > 0 && board[i + 1][j - 1] >= 1) aliveCount++;
                if (i < m - 1 && board[i + 1][j] >= 1) aliveCount++;
                if (i < m - 1 && j < n - 1 && board[i + 1][j + 1] >= 1) aliveCount++;
                if (board[i][j] == 0) {
                    //死到活 -1
                    if (aliveCount == 3) board[i][j] = -1;
                } else {
                    //活到死 2
                    if (aliveCount < 2 || aliveCount > 3) board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 1;
                else if (board[i][j] == 2) board[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
    }
}
