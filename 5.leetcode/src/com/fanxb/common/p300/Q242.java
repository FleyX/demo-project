package com.fanxb.common.p300;

/**
 * @author fanxb
 * @date 2021-10-25-下午4:25
 */
public class Q242 {
    public boolean isAnagram(String s, String t) {
        int sn = s.length(), tn = t.length();
        if (sn != tn) return false;
        int[] count = new int[128];
        for (int i = 0; i < sn; i++) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }
        for (int j : count) if (j != 0) return false;
        return true;
    }


    public static void main(String[] args) {
        int[][] params = {{-1, 3}};
    }
}
