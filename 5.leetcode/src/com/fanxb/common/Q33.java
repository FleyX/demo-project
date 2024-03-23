package com.fanxb.common;

public class Q33 {


    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int l = 0, r = n - 1;
        while (l < r) {
            boolean s = nums[l] < nums[r];
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else {
                if (nums[m] >= nums[0]) {
                    //说明m落在左边的升序
                    if (nums[m] < target) {
                        if (l == m) l++;
                        else l = m;
                    } else {
                        if (!s && nums[l] > target) {
                            //说明target在右边的升序里
                            if (l == m) l++;
                            else l = m;
                        } else {
                            r = m;
                        }

                    }
                } else {
                    //m落在右边的升序
                    if (nums[m] > target) {
                        r = m;
                    } else {
                        if (s || nums[l] > target) {
                            //说明target在右边的升序里
                            if (l == m) l++;
                            else l = m;
                        } else {
                            r = m;
                        }
                    }
                }
            }
        }
        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q33().search(new int[]{1, 3}, 0));
    }
}
