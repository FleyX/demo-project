package com.fanxb.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q224 {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case ' ':
                    break;
                case '(':
                case '+':
                case '-':
                    stack.push(ch + "");
                    break;
                case ')':
                    List<String> strs = new ArrayList<>();
                    String temp;
                    while (!(temp = stack.pop()).equals("("))
                        strs.add(temp);
                    stack.push(cal(strs).toString());
                    break;
                default:
                    //找到数字
                    StringBuilder builder = new StringBuilder().append(ch);
                    for (i = i + 1; i < len; i++) {
                        char ca = s.charAt(i);
                        if (ca >= '0' && ca <= '9') builder.append(ca);
                        else break;
                    }
                    i--;
                    stack.push(builder.toString());
            }
        }
        List<String> strings = new ArrayList<>();
        while (!stack.isEmpty())
            strings.add(stack.pop());
        return cal(strings);
    }

    private Integer cal(List<String> strs) {
        int len = strs.size();
        if (len == 1) return Integer.valueOf(strs.get(0));
        if (len == 2) return Integer.valueOf(strs.get(1) + strs.get(0));
        String first = strs.get(len - 1);
        int i, num1;
        if (first.equals("-")) {
            num1 = -1 * Integer.parseInt(strs.get(len - 2));
            i = len - 3;
        } else {
            num1 = Integer.parseInt(first);
            i = len - 2;
        }
        for (; i >= 0; i -= 2) {
            if (strs.get(i).equals("+")) {
                num1 += Integer.parseInt(strs.get(i - 1));
            } else {
                num1 -= Integer.parseInt(strs.get(i - 1));
            }
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(new Q224().calculate("-2+1"));
    }
}
