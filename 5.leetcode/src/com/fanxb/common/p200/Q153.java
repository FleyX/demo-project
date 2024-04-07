package com.fanxb.common.p200;

/**
 * Created with IntelliJ IDEA
 * 寻找旋转排序数组中的最小值
 * 地址： https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 思路： 需要找到分界点
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q153 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        int min = nums[0];
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[l] == nums[mid]) {
                //无法判断l,r所处的位置，l++
                if (nums[l] < min) {
                    min = nums[l];
                }
                l++;
            } else if (nums[l] < nums[mid]) {
                //说明两个点肯定都落在了左边的升续端内
                if (nums[l] < min) {
                    min = nums[l];
                }
                l = mid + 1;
            } else {
                //说明l肯定在左边区间，mid肯定在右边区间
                if (nums[mid] < min) {
                    min = nums[mid];
                }
                r = mid - 1;
            }
        }
        return min;
    }


    public int findMin1(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int l = 0, r = n - 1;
        while (l <= r) {
            if (nums[l] < nums[r]) {
                //说明l,r在同一段中
                return nums[l];
            }
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                //说明mid在左边的段
                l = mid + 1;
            } else {
                //说明mid在右边的段
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(new Q153().findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
