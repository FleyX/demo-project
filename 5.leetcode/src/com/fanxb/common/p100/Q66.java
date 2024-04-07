package com.fanxb.common.p100;

import java.util.Arrays;

public class Q66 {
    public int[] plusOne(int[] digits) {
        if (digits[0] == 0) return new int[]{1};
        int n = digits.length;
        digits[n - 1]++;
        boolean hasNext = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += hasNext ? 1 : 0;
            hasNext = digits[i] >= 10;
            if (hasNext) digits[i] = digits[i] - 10;
            else return digits;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        System.arraycopy(digits, 0, res, 1, res.length - 1);
        return res;
    }
}
