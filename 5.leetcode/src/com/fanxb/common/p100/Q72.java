package com.fanxb.common.p100;

/**
 * 编辑距离，可以对任意一个单词增加一个字母；删除一个字母；替换一个字母；
 * a增加一个字母相当于b删除一个字母
 * b增加一个字母相当于a删除一个字母
 * a替换一个字母相当于b替换一个字母
 * <p>
 * 字符串a,字符串b
 * <p>
 * 定义dp[i][j]为a中前i个字母变化为b中前j个字母需要的步骤
 * 考虑上面三种情况，存在以下三种转移情况
 * dp[i][j]=dp[i-1][j]+1;字母a增加一个字母
 * dp[i][j]=dp[i][j-1]+1;字母b增加一个字母
 * dp[i][j]=dp[i-1][j-1]+(a[i]==a[j]);字母替换，由于a[i],a[j]可能相同，不需要替换，所以不一定要走替换这一步
 * <p>
 * 极端情况：
 * dp[0][j]=j;
 * dp[i][0]=i;
 *
 * @author fanxb
 * @date 2021-08-31-下午10:15
 */
public class Q72 {

    public int minDistance(String word1, String word2) {
        int length1 = word1.length(), length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1)));
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        System.out.println(new Q72().minDistance("horse", "ros"));
    }
}
