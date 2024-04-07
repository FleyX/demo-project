package com.fanxb.common.p100;

public class Q137 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += num & 1;
                num = num >>> 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res | count[i] % 3;
            res = res << 1;
        }
        return res;
    }
}
