package com.fanxb.common;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q68 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] > target) {
                if (r == m) {
                    l++;
                } else {
                    r = m;
                }
            } else if (nums[m] == target) {
                return m;
            } else {
                if (l == m) {
                    l++;
                } else {
                    l = m;
                }
            }
        }
        return nums[l] < target ? l + 1 : l;
    }

    public static void main(String[] args) {
        System.out.println(new Q68().searchInsert(new int[]{1, 3, 5, 6}, 5));
    }
}
