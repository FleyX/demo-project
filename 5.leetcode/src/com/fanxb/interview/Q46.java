package com.fanxb.interview;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q46 {

    public int translateNum(int num) {
        String str = String.valueOf(num);
        //a=f(0),b=f(1)
        int a = 1, b = 1, sum = 1;
        for (int i = 1, length = str.length(); i < length; i++) {
            String temp = str.substring(i - 1, i + 1);
            sum = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? a + b : b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Q46().translateNum(12258));
    }
}
