package com.fanxb.common.p100;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/10 10:49
 */
public class Q9 {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        int temp = x, rev = 0;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp = temp / 10;
        }
        return x == rev;
    }

    public static void main(String[] args) {
        Q9 instance = new Q9();
        System.out.println(instance.isPalindrome(1212312));
        System.out.println(instance.isPalindrome(1410110141));
        System.out.println(instance.isPalindrome(-121));
    }
}
