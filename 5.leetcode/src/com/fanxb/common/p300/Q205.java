package com.fanxb.common.p300;

import java.util.Arrays;

public class Q205 {

    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[128];
        Arrays.fill(map, -1);
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char tc = t.charAt(i), sc = s.charAt(i);
            if (map[tc] == -1) map[tc] = sc;
            if (map[tc] != sc) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 3, 1};
    }
}
