package com.fanxb.common;

import java.util.LinkedList;
import java.util.List;

public class Q228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums.length == 0) return res;
        int startIndex = 0, length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] - nums[startIndex] != i - startIndex) {
                res.add(startIndex == i - 1 ? String.valueOf(nums[startIndex]) : (nums[startIndex] + "->" + nums[i - 1]));
                startIndex = i;
            }
        }
        res.add(startIndex == length - 1 ? String.valueOf(nums[startIndex]) : (nums[startIndex] + "->" + nums[length - 1]));
        return res;
    }
}
