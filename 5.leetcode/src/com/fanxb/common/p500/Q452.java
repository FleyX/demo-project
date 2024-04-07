package com.fanxb.common.p500;

import java.util.Arrays;

/**
 * 题目地址： https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 解题思路：贪心算法，按照结束点排序，
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q452 {

    public static int solution(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        //第一根箭的位置是第一个气球的结束点
        int endNum = points[0][1], count = 1;
        for (int[] point : points) {
            if (point[0] > endNum) {
                //当某个气球的开始点>箭的位置时说明需要一根新的箭了，箭位置为当前气球的结束点
                endNum = point[1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] s = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
//        int[][] s = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(solution(s));
    }
}
