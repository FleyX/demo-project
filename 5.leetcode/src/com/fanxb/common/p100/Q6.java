package com.fanxb.common.p100;

import java.util.Arrays;

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

    public String convert1(String s, int numRows) {
        int length = s.length();
        if (length <= 1 || numRows == 1) return s;
        int nSize = numRows * 2 - 2;
        int lineNum = (numRows - 1) * (length / nSize + 1);
        char[][] chars = new char[numRows][lineNum];
        for (int i = 0; i < numRows; i++) Arrays.fill(chars[i], ' ');
        int count = 0, m = 0, n = 0;
        for (int i = 0; i < length; i++) {
            chars[m][n] = s.charAt(i);
            count++;
            if (count == nSize) {
                count = 0;
                m--;
                n++;
            } else if (count < numRows) {
                m++;
            } else {
                m--;
                n++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < lineNum; j++) {
                if (chars[i][j] != ' ') {
                    builder.append(chars[i][j]);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q6().convert1("PAYPALISHIRING", 4));
    }
}
