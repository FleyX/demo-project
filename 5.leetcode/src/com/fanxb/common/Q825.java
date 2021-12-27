package com.fanxb.common;

import java.util.Arrays;

public class Q825 {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        Arrays.sort(ages);
        //二分查找100的分界点
        int index100 = search(ages, 100, 0, ages.length - 1);
        for (int i = search(ages, 15, 0, index100); i <= index100; i++) {
            int startIndex = search(ages, Double.valueOf(Math.ceil(0.5 * ages[i] + 7)).intValue(), 0, i);
            res += i - startIndex;
        }
        for (int i = index100; i < ages.length; i++) {
            int startIndex = search(ages, Double.valueOf(Math.ceil(0.5 * ages[i] + 7)).intValue(), index100, i);
            res += i - startIndex;
        }
        return res;
    }

    public int search(int[] ages, int target, int initL, int initR) {
        int l = initL, r = initR, mid = (l + r) / 2;
        while (l < r) {
            if (ages[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
            mid = (l + r) / 2;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Q825().numFriendRequests(new int[]{16, 16}));
    }


}
