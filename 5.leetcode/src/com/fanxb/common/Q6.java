package com.fanxb.common;

public class Q6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        int circle = 2 * numRows - 2;
        char[][] res = new char[numRows][Double.valueOf(Math.ceil(length / (circle * 1.0))).intValue() * (numRows - 1)];
        int y = 0, x = 0, count = 0;
        for (int i = 0; i < length; i++) {
            res[y][x] = s.charAt(i);
            count++;
            if (count == circle) {
                //一轮循环结束，重置
                count = 0;
                x++;
                y--;
            } else {
                if (count < numRows) {
                    y++;
                } else {
                    x++;
                    y--;
                }
            }

        }
        char[] strs = new char[length];
        count = 0;
        for (char[] temp : res) {
            for (char one : temp) {
                if (one != 0) {
                    strs[count++] = one;
                }
            }
        }
        return new String(strs);
    }

    public static void main(String[] args) {
        System.out.println(new Q6().convert("PAYPALISHIRING", 4));
    }
}
