package com.fanxb.common.p100;

/**
 * 定义f(n)表示爬n级台阶的方法
 *
 * @author fanxb
 * @date 2022/3/11 15:55
 */
public class Q70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int last1 = 1, last2 = 2, res = 2;
        for (int i = 3; i <= n; i++) {
            res = last1 + last2;
            last1 = last2;
            last2 = res;
        }
        return res;
    }


    public int climbStairs1(int n) {
        if (n == 1) return 1;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a+b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Q70().climbStairs(5));
    }
}
