package com.fanxb.common;

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
 *
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 0, r = x;
        long temp1, temp2, mid;
        while (true) {
            mid = (l + r) / 2;
            temp1 = mid * mid;
            temp2 = (mid + 1) * (mid + 1);

            if (temp1 == x || (temp1 < x && temp2 > x)) {
                return (int) mid;
            } else if (temp1 > x) {
                r = (int) mid;
            } else {
                l = (int) mid;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q69().mySqrt(2147395599));
    }
}
