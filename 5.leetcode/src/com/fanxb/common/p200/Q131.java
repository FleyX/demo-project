package com.fanxb.common.p200;

import java.util.*;

/**
 * 分割回文串
 *
 * @author fanxb
 * @date 2022/3/9 10:10
 */
public class Q131 {

    public List<List<String>> partition(String s) {
        //先用dp找到所有符合条件的回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < dp.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (i + 1 == j) {
                        dp[i][j] = b;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] && b;
                    }
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new Stack<>(), res, dp);
        return res;

    }

    /**
     * 分割字符串
     *
     * @param s     字符串
     * @param index 子串的起始位置
     * @param temp  临时存储已经分割后的字符串
     * @param res   存储最终分割结果
     * @param dp    dp结果
     * @author fanxb
     * date 2022/3/9 16:39
     */
    private void dfs(String s, int index, Stack<String> temp, List<List<String>> res, boolean[][] dp) {
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i + 1]) {
                String tempS = s.substring(index, i + 1);
                temp.push(tempS);
                dfs(s, i + 1, temp, res, dp);
                temp.pop();
            }

        }
    }


    public static void main(String[] args) {
    }
}
