package com.fanxb.common.p100;

import java.util.ArrayList;
import java.util.List;

public class Q52 {
    private List<Integer[]> state;
    //记录列上的皇后
    private boolean[] col;
    private int res;


    public int totalNQueens(int n) {
        state = new ArrayList<>(n);
        col = new boolean[n];
        res = 0;
        dfs(n, 0);
        return res;
    }

    private void dfs(int n, int cur) {
        if (state.size() == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            //当前行或者当前列已经放了，那么跳过
            if (col[i]) continue;
            //判断斜线上有没有存在的皇后，判断方法：主对角线行减列的差值相等，次对角线的行加列值相等
            int val1 = cur - i, val2 = cur + i;
            if (state.stream().anyMatch(item -> item[0] - item[1] == val1 || item[0] + item[1] == val2)) continue;
            state.add(new Integer[]{cur, i});
            col[i] = true;
            //往下一行放
            dfs(n, cur + 1);
            state.remove(state.size() - 1);
            col[i] = false;
        }
    }
}
