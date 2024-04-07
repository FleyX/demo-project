package com.fanxb.common.p100;

import java.util.Stack;

/**
 * @author fanxb
 * @date 2021-11-03-下午3:12
 */
public class Q42 {

    /**
     * 动态规划解法
     *
     * @param height height
     * @return int
     * @author fanxb
     * @date 2021/11/3 下午3:51
     */
    public int trap(int[] height) {
        int n = height.length;
        //leftMax[i]表示第i个位左边的最高高度,rightMax同理
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[n - 1 - i] = Math.max(rightMax[n - i], height[n - i - 1]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    /**
     * 单调栈解法
     *
     * @param height height
     * @return int int
     * @author fanxb
     * @date 2021/11/3 下午4:37
     */
    public int trap1(int[] height) {
        int res = 0;
        if (height.length <= 2) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //当前元素大于栈顶元素
                //栈里的元素大于等于2,说明可以开始接雨水了
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int l = stack.peek();
                res += (Math.min(height[i], height[l]) - height[bottom]) * (i - l - 1);
            }
            stack.push(i);
        }
        return res;
    }

    public int trap2(int[] height) {
        int length = height.length;
        //i左边的最大高度
        int[] left = new int[length];
        left[0] = 0;
        //i右边的最大高度
        int[] right = new int[length];
        right[length - 1] = 0;
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
            right[length - i - 1] = Math.max(right[length - i], height[length - i]);
        }
        int res = 0;
        for (int i = 1; i < length - 1; i++) {
            int temp = Math.min(left[i], right[i]) - height[i];
            if (temp > 0) {
                res += temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Q42().trap1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Q42().trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
