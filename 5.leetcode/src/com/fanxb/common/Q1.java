package com.fanxb.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanxb
 * @date 2021年12月26日 22:02
 */
public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numIndexMap.put(nums[i], i);
        }
        int cur;
        Integer targetIndex;
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            targetIndex = numIndexMap.get(target - cur);
            if (targetIndex != null && targetIndex > i) {
                return new int[]{i, targetIndex};
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            Integer targetI = map.get(target - nums[i]);
            if (targetI != null && targetI != i) return new int[]{i, map.get(target - nums[i])};
        }
        return null;
    }

    /**
     * 更优，一次循环即可
     *
     * @return int[]
     * @author fanxb
     * @date 2021/12/26 22:08
     */
    public int[] betterTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (numIndexMap.containsKey(target - nums[i])) {
                return new int[]{numIndexMap.get(target - nums[i]), i};
            }
            numIndexMap.put(nums[i], i);
        }
        return null;
    }
}
