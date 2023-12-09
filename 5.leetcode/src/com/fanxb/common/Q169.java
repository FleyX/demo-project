package com.fanxb.common;

import java.util.Arrays;

/**
 *
 */
public class Q169 {

    public int majorityElement(int[] nums) {
        /**
         * Moore voting
         * Suppose the first num is target num x,and set count as 1
         * And then iterate through the array from second num
         * if( count == 0 ) x = current num
         * continue
         * if x == current num count++ else count--
         */


        int x = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                x = nums[i];
                count = 1;
            } else if (x == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return x;
    }


    public static void main(String[] args) {
        int[] numbers = {10, 9, 9, 9, 10};
        System.out.println(new Q169().majorityElement(numbers));
    }
}
