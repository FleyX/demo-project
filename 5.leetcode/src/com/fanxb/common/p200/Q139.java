package com.fanxb.common.p200;

import java.util.*;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] cache = new boolean[s.length()];
        return bfs(s, 0, new HashSet<>(wordDict), cache);
    }

    private boolean bfs(String s, int i, Set<String> wordSet, boolean[] cache) {
        if (i >= s.length()) return true;
        if (cache[i]) return false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            stringBuilder.append(s.charAt(j));
            if (!wordSet.contains(stringBuilder.toString())) continue;
            boolean exist = bfs(s, j + 1, wordSet, cache);
            if (exist) return true;
            cache[j + 1] = true;
        }
        cache[i] = true;
        return false;
    }


    public boolean wordBreak1(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Q139().wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
