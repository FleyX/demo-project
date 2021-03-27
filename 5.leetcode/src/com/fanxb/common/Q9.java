package com.fanxb.common;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/10 10:49
 */
public class Q9 {

    public boolean isPalindrome(int x) {
        //小于0的数或者末尾为0的正数肯定不是回文数
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        long temp = 1;
        while (x / (temp * 10) > 0) {
            temp = temp * 10;
        }
        for (int i = 1; i < temp; temp = temp / 10, i *= 10) {
            System.out.println(x / i % 10 + ":" + x / temp % 10);
            if (x / i % 10 != x / temp % 10) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q9 instance = new Q9();
        System.out.println(instance.isPalindrome(1212312));
        System.out.println(instance.isPalindrome(1410110141));
        System.out.println(instance.isPalindrome(-121));
    }
}
