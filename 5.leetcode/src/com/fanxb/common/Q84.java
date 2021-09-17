package com.fanxb.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author fanxb
 * @date 2021-08-31-下午11:15
 */
public class Q84 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int currentHeight = heights[i];
            if (!stack.isEmpty()) {
                //说明下一个是更小的，一定能确定一些高度的面积
                while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                    int height = heights[stack.pop()];
                    while (!stack.isEmpty() && heights[stack.peek()] == height) {
                        stack.pop();
                    }
                    int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                    res = Math.max(res, height * width);
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            while (!stack.isEmpty() && heights[stack.peek()] == height) {
                stack.pop();
            }
            int width = stack.isEmpty() ? n : (n - stack.peek() - 1);
            res = Math.max(res, height * width);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q84().largestRectangleArea(new int[]{2, 1, 0, 2}));
    }
}
