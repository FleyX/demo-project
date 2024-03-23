package com.fanxb.common;

import java.util.*;

public class Q219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer index = map.get(num);
            if (index != null && Math.abs(i - index) <= k) return true;
            map.put(num, i);
        }
        return false;
    }

    public static void main(String[] args) {
    }

}
