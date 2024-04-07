package com.fanxb.common.p200;

import java.util.Arrays;
import java.util.EnumSet;

/**
 * 两数之和 II - 输入有序数组
 * <p>
 * 题目地址：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * 解题思路：
 * 两个指针从两端开始望中间搜索
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q167 {

    public static int[] solution(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int num;
        while ((num = numbers[i] + numbers[j]) != target) {
            if (num > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{i + 1, j + 1};
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[]{i+1, j+1};
            else if (sum > target) j--;
            else j++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution(numbers, 9)));
    }
}
