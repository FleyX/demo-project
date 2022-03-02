package com.fanxb.common;

/**
 * TODO
 *
 * @author fanxb
 * @date 2022/3/2 16:42
 */
public class Q26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        //不重复元素的个数
        int count = 0;
        //最后一个元素单独处理
        //找到一个重复序列的最后一个元素
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[count++] = nums[i];
            }
        }
        //由于是当前元素和下一个元素作比较，那么最后一个元素一定是目标元素
        nums[count++] = nums[n - 1];
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Q26().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
