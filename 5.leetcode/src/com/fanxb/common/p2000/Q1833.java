package com.fanxb.common.p2000;

import java.util.*;

/**
 * 两数相加
 *
 * @author fanxb
 * @date 2021/6/1
 **/
public class Q1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int i = 0; i < costs.length; i++) {
            coins -= costs[i];
            if (coins >= 0) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Q1833().maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
    }
}
