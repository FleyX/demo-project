package com.fanxb.common.p500;

import java.util.Arrays;

/**
 * 旋转链表
 * 题目地址：https://leetcode-cn.com/problems/assign-cookies/submissions/
 * 解题思路：
 * 贪心算法，优先让饥饿度最小的孩子吃能吃饱的最小的饼干
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q455 {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while (i<g.length&&j<s.length){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
    }
}
