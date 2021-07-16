package com.fanxb.common.offer;

/**
 * 两数相加
 *
 * @author fanxb
 * @date 2021/6/1
 **/
public class Q53 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        //二分查找目标值在数组中的位置
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] == target) {
                break;
            }
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                l = mid;
                break;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (nums[l] != target) {
            return 0;
        }
        int index = l, res = 1;
        //找左边的
        while (--index > 0 && nums[index] == target) {
            res++;
        }
        while (++l < nums.length && nums[l] == target) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q53().search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}
