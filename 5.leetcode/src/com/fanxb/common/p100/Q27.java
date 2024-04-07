package com.fanxb.common.p100;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * 移除元素
 * 地址：https://leetcode-cn.com/problems/remove-element/
 * 思路：
 * 暴力办法，两层for循环，每找到一个相同元素就将后面的所有元素向前移动一位
 * 还有一种简便点的办法，不需要删除重复元素，只需要将重复元素替换为不重复元素即可
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new Q27().removeElement1(arr, 2));
        System.out.println(Arrays.toString(arr));
    }
}
