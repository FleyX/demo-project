package com.fanxb.common.p100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q17 {
    private Set<String> res = new HashSet<>();
    private StringBuilder stringBuilder = new StringBuilder();
    private String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        dfs(digits.length(), digits, 0);
        return new ArrayList<>(res);
    }

    private void dfs(int size, String digits, int i) {
        if (stringBuilder.length() == size) {
            res.add(stringBuilder.toString());
            return;
        }
        for (char c : map[digits.charAt(i) - '0'].toCharArray()) {
            stringBuilder.append(c);
            dfs(size, digits, i + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
