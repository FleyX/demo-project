package com.fanxb.common;

/**
 * 具有给定数值的最小字符串
 * <p>
 * 题目地址：https://leetcode-cn.com/problems/smallest-string-with-a-given-numeric-value/
 * <p>
 * 解题思路：
 * 1. 贪心算法，字典序最小意思就是要把尽量把小的字母放前面，也可以说是把尽量大的数字放后面，因此有两种做法。
 * a. 每次放尽量小的字母在前面，然后判断后面的全放最大的字母能否满足（大于等于）k-已存在的数字和.如果能满足再放第二个,如果不满足就把当前的字母加大1,再判断直到满足要求
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q605 {

    public static boolean solution(int[] flowerbed, int n) {
        //第i个位置当成花坛的起点，前一个位置肯定没种花
        int i = 0;
        int count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1) {
                //第i个有花，下一个可能有花的位置肯定是i+2
                i += 2;
            } else {
                //第i个位置没花
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    //i是最后一个位置 或者 i+1没花
                    count++;
                    i += 2;
                } else {
                    //第i个位置没花，第i+1个位置有花，说明下一个种花的起点至少是i+3
                    i += 3;
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int[] s = {1, 0, 0, 0, 0, 1};
        System.out.println(solution(s, 2));
    }
}
