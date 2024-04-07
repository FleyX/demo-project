package com.fanxb.common.p400;

import java.util.*;

public class Q347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
        }
        PriorityQueue<Integer> res = new PriorityQueue<>(Comparator.comparingInt(countMap::get));
        for (int num : countMap.keySet()) {
            if (res.size() < k) {
                res.add(num);
            } else if (countMap.get(res.peek()) < countMap.get(num)) {
                res.poll();
                res.add(num);
            }
        }
        int[] realRes = new int[k];
        for (int i = 0; i < k; i++) {
            realRes[i] = res.poll();
        }
        return realRes;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q347().topKFrequent(new int[]{1}, 1)));
    }

}
