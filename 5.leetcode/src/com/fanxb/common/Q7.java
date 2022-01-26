package com.fanxb.common;

public class Q7 {
    public int reverse(int x) {
        int res = 0;
        int last = 0;
        while (x != 0) {
            last = res;
            res = res * 10 + x % 10;
            x = x / 10;
            //判断是否溢出(原理：数字溢出后肯定和原来不一样，通过%10后和上一个值比较，一样说明未溢出)
            if (res / 10 != last) {
                return 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q7().reverse(1234567));
    }
}
