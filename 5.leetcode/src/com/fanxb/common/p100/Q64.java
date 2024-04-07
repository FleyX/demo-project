package com.fanxb.common.p100;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q64 {
    public int sumNums(int n) {
        boolean temp = n - 1 > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Q64().sumNums(10));
    }
}
