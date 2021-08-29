package com.fanxb.common;

import java.util.*;

public class Q215 {

    public int findKthLargest(int[] nums, int k) {
        //堆
        List<Integer> heads = new ArrayList<>(k + 1);
        heads.add(0);

        for (int num : nums) {
            //建堆
            if (heads.size() < k + 1) {
                heads.add(num);
                for (int i = heads.size() - 1; i > 0; i--) {
                    cal(heads, i);
                }
            } else if (num >= heads.get(1)) {
                heads.set(1, num);
                cal(heads, 1);
            }
        }
        return heads.get(1);
    }

    private static void cal(List<Integer> heads, int i) {
        int left = 2 * i;
        if (left < heads.size() && heads.get(i) > heads.get(left)) {
            Collections.swap(heads, i, left);
            cal(heads, left);
        }
        int right = 2 * i + 1;
        if (right < heads.size() && heads.get(i) > heads.get(right)) {
            Collections.swap(heads, i, right);
            cal(heads, right);
        }
    }

    public static void main(String[] args) {
        int[] people = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new Q215().findKthLargest(people, 4));
    }
}
