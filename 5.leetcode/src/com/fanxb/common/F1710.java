package com.fanxb.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加
 *
 * @author fanxb
 * @date 2021/6/1
 **/
public class F1710 {

    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int x = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                x = num;
                count++;
            } else {
                count += x == num ? 1 : -1;
            }
        }
        if (count > 0) {
            //说明还有剩的元素
            count = 0;
            for (int num : nums) {
                if (x == num) {
                    count++;
                }
                if (count > nums.length / 2) {
                    return x;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new F1710().majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
    }
}
