package com.fanxb.common.p200;

public class Q130 {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isBoard = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                if (isBoard && board[i][j] == 'O') {
                    dfs(board, i, j, m, n);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j]=='0') board[i][j]='O';
            }
        }
    }

    /**
     * 是否有边上的
     *
     * @return
     */
    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'X' || board[i][j] == '0') return;
        board[i][j] = '0';
        dfs(board, i + 1, j, m, n);
        dfs(board, i - 1, j, m, n);
        dfs(board, i, j + 1, m, n);
        dfs(board, i, j - 1, m, n);
    }
}
