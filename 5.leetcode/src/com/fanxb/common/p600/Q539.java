package com.fanxb.common.p600;

import java.util.Arrays;
import java.util.List;

public class Q539 {
    public int findMinDifference(List<String> timePoints) {
        String zero = "00:00";
        for (int i = 0; i < timePoints.size(); i++) {
            if (timePoints.get(i).equals(zero)) {
                timePoints.set(i, "24:00");
            }
        }
        timePoints.sort(String::compareTo);
        int res = Integer.MAX_VALUE;
        int cur = cal(timePoints.get(0)), next = 0;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            next = cal(timePoints.get(i + 1));
            if (cur == next) {
                return 0;
            }
            res = Math.min(res, next - cur);
            cur = next;
        }
        //最后计算首尾的时间差
        res = Math.min(cal("24:00") - cur + cal(timePoints.get(0)), res);
        return res;
    }

    private int cal(String point) {
        String[] nums = point.split(":");
        return Integer.parseInt(nums[0]) * 60 + Integer.parseInt(nums[1]);
    }

    public static void main(String[] args) {
        System.out.println(new Q539().findMinDifference(Arrays.asList("05:31", "22:08", "00:35")));
    }
}
