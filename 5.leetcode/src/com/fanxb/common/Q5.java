package com.fanxb.common;

/**
 * 定义dp[i][j]表示从i到j的字符串是否为回文串
 * 已知如下情况：
 * 1. 当j-i==0时，dp[i][j]是回文串
 * 2. 当j-i==1时，判断s[1]是否等于s[j]
 * 3. dp[i][j]=dp[i+1][j-1] && s[i]==s[j]
 * 注意坑点：由于第三个转移情况是从i到i+1所以循环的处理很重要，不能直接循环i从0-》n,j从i到n,这样会出现dp[i+1][j-1]的状态还不知道的情况
 *
 * @author fanxb
 * @date 2021-08-31-下午10:31
 */
public class Q5 {

    public String longestPalindrome(String s) {
        int n = s.length(), max = 0, resI = 0, resJ = 0;
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        //先从长度为1的字符串开始处理
        for (int length = 1; length <= s.length(); length++) {
            //i左边界，j右边界
            for (int i = 0; i < s.length(); i++) {
                int j = i + length - 1;
                if (j >= s.length()) {
                    continue;
                }
                if (length == 1) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = length == 2 || dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    resI = i;
                    resJ = j;
                }
            }
        }
        return s.substring(resI, resJ + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Q5().longestPalindrome("babad"));
    }
}
