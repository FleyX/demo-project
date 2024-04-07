package com.fanxb.common.p100;

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

    public int search1(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] > nums[r]) {
                //说明l,r分别在两段中
                if (target < nums[l]) {
                    //说明target在右边的段
                    if (nums[mid] >= nums[l]) l = mid + 1; //mid在左边
                    else if (nums[mid] > target) r = mid - 1; //mid在左边
                    else l = mid + 1;
                } else {
                    //target在左边的段
                    if (nums[mid] < nums[l]) r = mid - 1; //mid在左边
                    else if (nums[mid] > target) r = mid - 1; //mid在右边
                    else l = mid + 1;
                }
            } else {
                if (nums[mid] > target) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q33().search1(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
