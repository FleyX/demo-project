package com.fanxb.common;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 旋转链表
 * 题目地址：https://leetcode-cn.com/problems/assign-cookies/submissions/
 * 解题思路：
 * 贪心算法，想不明白
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q135 {

    public static int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        Arrays.fill(candys, 1);
        //从左到右
        for (int i = 1; i < candys.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(candys));
        for (int i = candys.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candys[i - 1] <= candys[i]) {
                candys[i - 1] = candys[i] + 1;
            }
        }
        int count = 0;
        for (int item : candys) {
            count += item;
        }
        System.out.println(Arrays.toString(candys));
        return count;
    }

    public static int candy1(int[] ratings) {
        //every one set one candy
        int length = ratings.length;
        int[] res = new int[length];
        Arrays.fill(res, 1);
        for (int i = 1; i < length; i++) {
            //从左到右遍历，如果下一个人分数更高那么多发一颗糖
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]) {
                res[i] = res[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int temp : res) {
            sum += temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] s = {1, 3, 4, 5, 2};
        System.out.println(Arrays.toString(s));
        System.out.println(candy1(s));
    }
}
