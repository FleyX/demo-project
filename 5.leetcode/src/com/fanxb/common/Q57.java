package com.fanxb.common;

import java.util.Arrays;

public class Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length, i = 0, count = 0;
        int[][] res = new int[length + 1][2];
        if (intervals.length == 0) return new int[][]{newInterval};
        if (newInterval[1] < intervals[0][0]) {
            //说明放到最前面
            res[count++] = newInterval;
            for (int[] num : intervals) res[count++] = num;
            return res;
        }
        if (newInterval[0] > intervals[length - 1][1]) {
            //说明放到最后
            for (int[] num : intervals) res[count++] = num;
            res[count++] = newInterval;
            return res;
        }
        for (; i < length; i++) {
            //开始找开始插入的位置
            if (intervals[i][1] >= newInterval[0]) {
                if (newInterval[1] < intervals[i][0]) {
                    //说明无交叉，新的放到i前面
                    res[count++] = newInterval;
                    for (; i < length; i++) res[count++] = intervals[i];
                    return res;
                }
                break;
            } else {
                res[count++] = intervals[i];
            }
        }
        //有交叉，从i开始进行合并
        int[] start = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
        i++;
        for (; i < length; i++) {
            int[] temp = intervals[i];
            if (temp[0] <= start[1]) {
                //说明存在重叠，进行合并
                start[1] = Math.max(temp[1], start[1]);
            } else {
                //说明不存在重叠了，
                res[count++] = start;
                break;
            }
        }
        if (i == length) {
            //说明循环完了
            res[count++] = start;
        } else {
            //说明还有一段没合并完
            for (; i < length; i++) {
                res[count++] = intervals[i];
            }
        }
        return Arrays.copyOf(res, count);
    }
}
