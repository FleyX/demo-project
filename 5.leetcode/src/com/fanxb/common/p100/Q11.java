package com.fanxb.common.p100;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/10 10:49
 */
public class Q11 {

    public int maxArea(int[] height) {
        int length = height.length;
        int max = 0, i = 0, j = length - 1;
        while (i < j) {
            int temp = (j - i) * Math.min(height[i], height[j]);
            if (max < temp) max = temp;
            if (height[i] > height[j]) j--;
            else i++;
        }
        return max;
    }

    public static void main(String[] args) {
        Q11 instance = new Q11();
    }
}
