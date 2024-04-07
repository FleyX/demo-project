package com.fanxb.common.p200;

public class Q162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int l = 0, r = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            Integer midL = mid > 0 && mid < n ? nums[mid - 1] : null;
            Integer midR = mid >= 0 && mid < n - 1 ? nums[mid + 1] : null;
            if ((midL == null || midL < nums[mid]) && (midR == null || nums[mid] > midR)) return mid;
            else if (midR == null || nums[mid] > midR) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}
