package com.fanxb.common.p500;

import java.lang.reflect.AccessibleObject;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 地址: https://leetcode-cn.com/problems/non-overlapping-intervals
 *
 * @author fanxb
 * Date: 2020/6/11 10:58
 */
public class Q435 {
    public static int solution(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0, i = 0, j = 1;
        while (j < intervals.length) {
            if (intervals[i][1] <= intervals[j][0]) {
                //说明第i个区间和第j个区间，所以将i移动到j,再和j+1比较
                i = j;
            } else {
                //说明第i个区间和第j个区间重复,干掉j,i再和j+1比较
                count++;
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {2, 3}, {1, 8}};
        System.out.println(solution(arr));
    }
}
