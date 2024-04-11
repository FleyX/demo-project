package com.fanxb.common.p300;

import java.util.*;

public class Q332 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        Set<Integer> set = new HashSet<>();
        for (int coin : coins) {
            set.add(coin);
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (amount - coins[j] > 0 && dp[amount - coins[j]] >= 0) {
                    min = Math.min(dp[amount - coins[j]] + 1, min);
                }
            }
            if (min != Integer.MAX_VALUE) dp[i] = min;
        }
        return dp[amount];
    }
}
