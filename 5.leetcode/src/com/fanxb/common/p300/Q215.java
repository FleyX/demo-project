package com.fanxb.common.p300;

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

    private static class Solution {
        public int findKthLargest(int[] nums, int k) {
            int size = nums.length;
            for (int i = parent(size - 1); i >= 0; i--) {
                adjust(nums, size, i);
            }
            for (int i = 0; i < k - 1; i++) {
                swap(nums, 0, --size);
                adjust(nums, size, 0);
            }
            return nums[0];
        }

        private void adjust(int[] nums, int size, int i) {
            int leftI = left(size, i), rightI = right(size, i);
            int maxI = i;
            if (leftI > -1 && nums[maxI] < nums[leftI]) maxI = leftI;
            if (rightI > -1 && nums[maxI] < nums[rightI]) maxI = rightI;
            if (maxI == i) return;
            swap(nums, i, maxI);
            adjust(nums, size, maxI);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private int left(int size, int i) {
            int val = 2 * i + 1;
            return val >= size ? -1 : val;
        }

        private int right(int size, int i) {
            int val = 2 * i + 2;
            return val >= size ? -1 : val;
        }

    }

    public static void main(String[] args) {
        int[] people = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new Q215().findKthLargest(people, 4));
    }
}
