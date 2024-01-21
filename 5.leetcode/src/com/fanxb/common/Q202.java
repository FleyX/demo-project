package com.fanxb.common;

import java.util.HashSet;
import java.util.Set;

public class Q202 {

    public boolean isHappy(int n) {
        Set<Long> cache = new HashSet<>();
        long temp = n;
        while (true) {
            String[] strs = Long.toString(temp).split("");
            long res = 0;
            for (String s : strs) res += (long) Integer.parseInt(s) * Integer.parseInt(s);
            if (res == 1) return true;
            if (cache.contains(res)) return false;
            cache.add(res);
            temp = res;
        }
    }

    public static void main(String[] args) {
        new Q202().isHappy(2);
    }
}
