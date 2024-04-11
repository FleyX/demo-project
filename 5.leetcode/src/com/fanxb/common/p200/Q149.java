package com.fanxb.common.p200;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * 寻找旋转排序数组中的最小值
 * 地址： https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 思路： 需要找到分界点
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q149 {
    public int maxPoints(int[][] points) {
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            int[] a1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] a2 = points[j];
                int n = 2;
                for (int k = j + 1; k < points.length; k++) {
                    int[] a3 = points[k];
                    if ((a2[1] - a1[1]) * (a3[0] - a1[0]) == (a3[1] - a1[1]) * (a2[0] - a1[0])) {
                        n++;
                    }
                }
                if (n > max) {
                    max = n;
                }
            }
        }
        return max;
    }

    public int maxPoints1(int[][] points) {
        int n = points.length;
        if (n < 3) return points.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = 2;
                for (int k = j + 1; k < n; k++) {
                    if ((points[k][0] - points[i][0]) * (points[j][1] - points[i][1]) == (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]))
                        temp++;
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }

    public int maxPoints2(int[][] points) {
        int n = points.length;
        if (n < 3) return n;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[j][0] - points[i][0], y = points[j][1] - points[i][1];
                int gcd = gcd(x, y);
                String key = (x / gcd) + "/" + (y / gcd);
                int count = map.getOrDefault(key, 1) + 1;
                map.put(key, count);
                max = Math.max(max, count);
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new Q149().maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }
}
