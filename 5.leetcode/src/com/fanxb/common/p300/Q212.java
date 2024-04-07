package com.fanxb.common.p300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212 {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>(List.of(words));
        List<String> res = new ArrayList<>(words.length);
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[][] cache = new int[board.length][board[0].length];
                dfs(set, res, board, "", cache, 0, 0, board.length, board[0].length);
            }
        }
        return res;
    }

    private void dfs(Set<String> set, List<String> res, char[][] board, String temp, int[][] cache, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || temp.length() >= 10) return;
        if (cache[i][j] == 1) return;
        char c = board[i][j];
        cache[i][j] = 1;
        String newStr = temp + c;
        if (set.contains(newStr)) {
            res.add(newStr);
            set.remove(newStr);
        }
        dfs(set, res, board, newStr, cache, i, j - 1, m, n);
        dfs(set, res, board, newStr, cache, i, j + 1, m, n);
        dfs(set, res, board, newStr, cache, i - 1, j, m, n);
        dfs(set, res, board, newStr, cache, i + 1, j, m, n);
    }

    public static void main(String[] args) {
        new Q212().findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"});
    }
}
