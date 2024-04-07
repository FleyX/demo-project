package com.fanxb.common.p400;

import java.util.*;

public class Q373 {
    private boolean isExchange = false;

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            isExchange = true;
            return kSmallestPairs(nums2, nums1, k);
        }
        List<List<Integer>> res = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < Math.min(m, k); i++) queue.add(new int[]{i, 0, nums1[i] + nums2[0]});
        while (k-- > 0) {
            int[] temp = queue.poll();
            if (isExchange) res.add(Arrays.asList(nums2[temp[1]], nums1[temp[0]]));
            else res.add(Arrays.asList(nums1[temp[0]], nums2[temp[1]]));
            if (temp[1] < n - 1)
                queue.add(new int[]{temp[0], temp[1] + 1, nums1[temp[0]] + nums2[temp[1] + 1]});
        }
        return res;
    }
}
