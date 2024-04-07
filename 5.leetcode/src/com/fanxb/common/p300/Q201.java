package com.fanxb.common.p300;

public class Q201 {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while (left < right) {
            left >>>= 1;
            right >>>= 1;
            count++;
        }
        return left << count;
    }

    public int rangeBitwiseAnd1(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }
}
