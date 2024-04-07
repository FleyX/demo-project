package com.fanxb.common.p100;

public class Q79 {
    private int[][] step = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, chars, 0, i, j, m, n)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int k, int x, int y, int m, int n) {
        if (word[k] != board[x][y]) return false;
        if (k == word.length - 1) return true;
        board[x][y] = ' ';
        for (int[] item : step) {
            int x1 = x + item[0], y1 = y + item[1];
            if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || board[x1][y1] == ' ') continue;
            if (dfs(board, word, k + 1, x1, y1, m, n)) return true;
        }
        board[x][y] = word[k];
        return false;
    }
}
