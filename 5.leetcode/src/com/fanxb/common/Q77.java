package com.fanxb.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> temp = new ArrayList<>(k);
        dfs(ans, temp, n, k, 1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> temp, int n, int k, int cur) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = cur; i <= n; i++) {
            temp.add(i);
            dfs(ans, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Q77().combine(4, 2);
    }

}
