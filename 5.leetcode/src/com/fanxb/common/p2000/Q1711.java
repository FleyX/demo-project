package com.fanxb.common.p2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加
 *
 * @author fanxb
 * @date 2021/6/1
 **/
public class Q1711 {

    public int countPairs(int[] deliciousness) {
        int maxValue = 0;
        for (int item : deliciousness) {
            if (item > maxValue) {
                maxValue = item;
            }
        }
        Map<Integer, Integer> numCountMap = new HashMap<>(deliciousness.length);
        double val = Math.pow(10, 9) + 7;
        long count = 0;
        for (int num : deliciousness) {
            for (int a = 1; a <= maxValue*2; a <<= 1) {
                count += numCountMap.getOrDefault(a - num, 0);
            }
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }
        return (int) (count % val);
    }

    public static void main(String[] args) {
        System.out.println(new Q1711().countPairs(new int[]{1, 3, 5, 7, 9}));
    }
}
