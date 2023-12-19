package com.fanxb.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q55 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (val < i) {
                //说明走不到这一步，不用继续了
                return false;
            }
            val = Math.max(val, i + nums[i]);
        }
        return val >= n - 1;

    }

    public static void main(String[] args) {
        System.out.println(new Q55().canJump(new int[]{1, 0, 1, 0}));
    }
}
