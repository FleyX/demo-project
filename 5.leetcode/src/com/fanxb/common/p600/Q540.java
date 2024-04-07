package com.fanxb.common.p600;

/**
 * Created with IntelliJ IDEA
 * 寻找旋转排序数组中的最小值 II
 * 地址： https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 思路： 观察可以发现当没有异常点时，每个奇数位和偶数位都是一致的，一旦加入异常点会导致从异常点开始奇偶位的数不一直
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if ((mid + 1) % 2 == 0 ? nums[mid] == nums[mid - 1] : nums[mid] == nums[mid + 1]) {
                //mid所处的位置，奇数位和偶数位的值一样，说明异常点在mid的后面
                l = mid + 1;
            } else {
                //说明异常点在mid或mid之前
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(new Q540().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }
}
