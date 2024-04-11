package com.fanxb.common.p2000;

/**
 * 具有给定数值的最小字符串
 * <p>
 * 题目地址：https://leetcode-cn.com/problems/smallest-string-with-a-given-numeric-value/
 * <p>
 * 解题思路：
 * 1. 贪心算法，字典序最小意思就是要把尽量把小的字母放前面，也可以说是把尽量大的数字放后面，因此有两种做法。
 * a. 每次放尽量小的字母在前面，然后判断后面的全放最大的字母能否满足（大于等于）k-已存在的数字和.如果能满足再放第二个,如果不满足就把当前的字母加大1,再判断直到满足要求
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q1663 {

    public String translateNum1(int n, int k) {
        char[] res = new char[n];
        //放入的数字和
        int num1 = 0;
        for (int i = 0; i < n; i++) {
            short temp = 1;
            while ((n - i - 1) * 26 + num1 + temp < k) {
                //当前位置放temp后，即使后面全部为26也无法满足,所以当前位置需要+1
                temp++;
            }
            num1 += temp;
            res[i] = (char) ('a' + temp - 1);
        }
        return new String(res);
    }

    /**
     * 更优的方法，没有子循环
     *
     * @return java.lang.String
     * @author fanxb
     * @date 2021/3/26
     **/
    public String translateNum(int n, int k) {
        char[] res = new char[n];
        //放入的数字和
        int num1 = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            if ((temp = (26 * (n - i - 1) - (k - num1))) >= 0) {
                //说明剩下的位置全放26至少能够满足需求
                res[i] = 'a';
                num1 += 1;
            } else {
                //说明剩下位置全放26仍然缺-temp，所以第i个位置为-temp
                res[i] = (char) ('a' - temp - 1);
                num1 -= temp;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(new Q1663().translateNum(1, 26));
        System.out.println(new Q1663().translateNum1(1, 26));
        System.out.println(4<<1);
    }
}
