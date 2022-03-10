package com.fanxb.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 分割回文串
 *
 * @author fanxb
 * @date 2022/3/9 10:10
 */
public class Q132 {

    public int minCut(String s) {
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
        //再次dp找到最小分割次数.定义minArr[i]为从0到i的最小分割次数
        int[] minArr = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            //定义l，当l->i构成回文串时，此时分割次数为=minArr[l-1]+1.找到最小的l
            int temp = i;
            for (int l = 0; l <= i; l++) {
                if (dp[l][i]) {
                    temp = Math.min(temp, l == 0 ? 0 : minArr[l - 1] + 1);
                }
            }
            minArr[i] = temp;
        }
        return minArr[s.length() - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Q132().minCut("aab"));
    }
}
