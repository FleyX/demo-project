package com.fanxb.common.p2000;

public class Q1688 {
    private static int[] res = new int[201];

    static {
        res[1] = 0;
        res[2] = 1;
        //是否偶数
        boolean isTwo = false;
        for (int i = 3; i <= 200; i++) {
            if (isTwo) {
                res[i] = i / 2 + res[i / 2];
            } else {
                res[i] = (i - 1) / 2 + res[(i - 1) / 2 + 1];
            }
            isTwo = !isTwo;
        }
    }

    public int numberOfMatches(int n) {
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(new Q1688().numberOfMatches(14));
    }
}
