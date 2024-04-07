package com.fanxb.common.p200;


import java.util.HashSet;
import java.util.Set;

public class Q128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) set.add(num);
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                //说明num是一个序列的起点
                int temp = num, curRes = 1;
                while (set.contains(++temp)) curRes++;
                res = Math.max(res, curRes);
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
