package com.fanxb.common.p700;

/**
 * 平方数之和
 * 题目地址: https://leetcode-cn.com/problems/sum-of-square-numbers/
 * 解题思路： 滑动窗口
 * 1. 这两个数的取值只可能是[0,(int) Math.sqrt(c)]中的，因此采用滑动窗口，设定l=0,r=(int)Math.sqrt(c)
 * 2. 判断l是否不大于r,否则返回false
 * 3. sum=l*l+r*r，.如果sum&lt;c,l++.
 * 4. 如果sum=c,返回true
 * 5. 如果sum&lt;c,l++,重复2
 * 6. 如果sum>c,r--,l++; 当r--的时候l必然++
 *
 * @author fanxb
 * Date: 2021/4/2 15:10
 */
public class Q633 {

    public static boolean solution(int c) {
        int l = 0, r = (int) Math.sqrt(c);
        int sum;
        while (l <= r) {
            if ((sum = l * l + r * r) < c) {
                l++;
            } else if (sum == c) {
                return true;
            } else {
                r--;
                l++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(solution(1));
    }
}
