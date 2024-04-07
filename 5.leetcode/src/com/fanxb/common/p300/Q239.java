package com.fanxb.common.p300;

import java.util.*;

/**
 * 定义转移方程dp[i][j]为长度为i+1的窗口在位置j的最大值
 * 已知dp[0][j]=num[j]
 * 转移方程dp[i][j]=max(dp[i-1][j],num[i+j])
 *
 * @author fanxb
 * @date 2021-08-31-下午11:15
 */
public class Q239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        //使用链表，构造一个递减的单调链表
        LinkedList<Integer> indexList = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!indexList.isEmpty() && nums[indexList.peekLast()] < nums[i]) {
                indexList.removeLast();
            }
            indexList.addLast(i);
            if (indexList.getFirst() < i - k + 1) {
                indexList.removeFirst();
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[indexList.getFirst()];
            }
        }
        return res;
    }

    public int[] lowMaxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] current = Arrays.copyOf(nums, n - k + 1);
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                if (nums[i + j] > current[j]) {
                    current[j] = nums[i + j];
                }
            }
        }
        return current;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q239().maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4)));
    }
}
