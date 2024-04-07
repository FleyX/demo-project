package com.fanxb.common.p300;

public class Q200 {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] == '0' || grid[i][j] == '2') return;
        //访问过的陆地
        grid[i][j] = '2';
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i + 1, j, m, n);
    }
}
