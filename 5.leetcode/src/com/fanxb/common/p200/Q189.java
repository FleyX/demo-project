package com.fanxb.common.p200;

import java.util.Arrays;

/**
 *
 */
public class Q189 {

    /**
     * set n = nums.length
     * first solution:
     * create a new array
     * copy origin array from nums[n-k] to nums[n-1]
     * copy origin array from nums[0] to nums[n-k-1]
     * second solution:
     * move every num to right k
     * third solution:
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] res = new int[nums.length];
        int j = 0;
        for (int i = n - k; i < n; i++) {
            res[j++] = nums[i];
        }
        for (int i = 0; i < n - k; i++) {
            res[j++] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, n);
    }

    /**
     * don't create a new array.
     * move num group
     * group 0: index: 0 0+k  0+2k 0+3k ...
     * group 1: index: 1 1+k  1+2k 1+3k ...
     * ...
     * group i: index: i i+k  i+2k i+3k ...
     * ...
     * group k-1: index: k-1 k-1+k  k-1 +2k k-1+3k ...
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (n < 2 || k == 0) {
            return;
        }
        int count = 0, start = 0;
        int curVal = nums[0], nextVal, curIndex = 0, nextIndex;
        while (count < n) {
            do {
                nextIndex = (curIndex + k) % n;
                nextVal = nums[nextIndex];
                nums[nextIndex] = curVal;
                curIndex = nextIndex;
                curVal = nextVal;
                count++;
            } while (curIndex != start);
            start++;
            curVal = nums[start];
            curIndex = start;
        }
    }


    public static void main(String[] args) {
        int[] numbers = {1, 2};
        new Q189().rotate2(numbers, 2);
        System.out.println(Arrays.toString(numbers));
    }
}
