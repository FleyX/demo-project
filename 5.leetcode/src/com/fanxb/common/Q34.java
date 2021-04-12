package com.fanxb.common;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * x 的平方根
 * 地址： https://leetcode-cn.com/problems/sqrtx/
 * 思路： 题目要求求解一个数的平方根的整数部分，那就那就相当于找到一个数num,使其满足num*mum==x || num*num&lt;x && (num+1)*(num+1)>x
 * 可通过二分查找来进行求解，num的值一定是[0,x]中的一个数
 * 1. 首先设定l=0,r=x
 * 2. mid=(l+r)/2,temp1=mid*mid,temp2=(mid+1)*(mid+1)
 * 3. 如果temp1 == x || (temp1 < x && temp2 > x)满足结果即为mid
 * 4. 否则判断temp1>x,如果满足r=mid,重复2
 * 5. 否则l=mid,重复2
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1;
        if (target < nums[0] || target > nums[r]) {
            return new int[]{-1, -1};
        }
        int mid;
        while (true) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid + 1] == target) {
                mid = mid + 1;
                break;
            } else if (nums[mid] < target) {
                if (nums[mid + 1] > target) {
                    return new int[]{-1, -1};
                }
                l = mid;
            } else {
                r = mid;
            }
        }
        //从mid向两端查找
        l = mid;
        r = mid;
        while (true) {
            boolean out = true;
            if (l > 0 && nums[l - 1] == target) {
                l--;
                out = false;
            }
            if (r < nums.length - 1 && nums[r + 1] == target) {
                r++;
                out = false;
            }
            if (out) {
                break;
            }
        }
        return new int[]{l, r};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q34().searchRange(new int[]{1, 4}, 4)));
    }
}
