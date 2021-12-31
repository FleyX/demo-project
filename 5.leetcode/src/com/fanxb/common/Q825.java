package com.fanxb.common;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Q825 {
    public int numFriendRequests(int[] ages) {
        //年龄计数
        int[] ageCount = new int[121];
        for (int age : ages) {
            ageCount[age]++;
        }
        //计算前缀和
        int[] preCount = new int[ageCount.length];
        for (int i = 1; i < ageCount.length; i++) {
            preCount[i] = preCount[i - 1] + ageCount[i];
        }
        int res = 0;
        //从15岁开始遍历
        for (int i = 15; i < ageCount.length; i++) {
            if (ageCount[i] == 0) {
                continue;
            }
            int startAge = i / 2 + 7;
            res += ageCount[i] * (preCount[i] - preCount[startAge] - 1);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Q825().numFriendRequests(new int[]{16, 16}));
    }


}
