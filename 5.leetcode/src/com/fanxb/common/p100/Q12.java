package com.fanxb.common.p100;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/10 10:49
 */
public class Q12 {

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                stringBuilder.append("M");
                num -= 1000;
            } else if (num >= 900) {
                stringBuilder.append("CM");
                num -= 900;
            } else if (num >= 500) {
                stringBuilder.append("D");
                num -= 500;
            } else if (num >= 400) {
                stringBuilder.append("CD");
                num -= 400;
            } else if (num >= 100) {
                stringBuilder.append("C");
                num -= 100;
            } else if (num >= 90) {
                stringBuilder.append("XC");
                num -= 90;
            } else if (num >= 50) {
                stringBuilder.append("L");
                num -= 50;
            } else if (num >= 40) {
                stringBuilder.append("XL");
                num -= 40;
            } else if (num >= 10) {
                stringBuilder.append("X");
                num -= 10;
            } else if (num == 9) {
                stringBuilder.append("IX");
                num -= 9;
            } else if (num >= 5) {
                stringBuilder.append("V");
                num -= 5;
            } else if (num == 4) {
                stringBuilder.append("IV");
                num -= 4;
            } else {
                stringBuilder.append("I");
                num -= 1;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Q12 instance = new Q12();
        System.out.println(instance.intToRoman(3));
        System.out.println(instance.intToRoman(9));
        System.out.println(instance.intToRoman(58));
        System.out.println(instance.intToRoman(1994));
    }
}
