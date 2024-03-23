package com.fanxb.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int length = intervals.length, count = 0;
        int[][] res = new int[intervals.length][2];
        int[] startArr = intervals[0];
        for (int i = 1; i < length; i++) {
            int[] temp = intervals[i];
            if (temp[0]<=startArr[1]) {
                //可以开始合并
                startArr[1] = Math.max(startArr[1], temp[1]);
            } else {
                res[count++] = startArr;
                startArr = temp;
            }
        }
        res[count++] = startArr;
        return Arrays.copyOf(res, count);
    }
}
