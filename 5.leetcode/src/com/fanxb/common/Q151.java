package com.fanxb.common;

import java.util.Stack;

public class Q151 {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (!temp.isEmpty()) {
                    stack.push(temp.toString());
                    temp = new StringBuilder();
                }
            } else {
                temp.append(s.charAt(i));
            }
        }
        if (!temp.isEmpty()) stack.push(temp.toString());
        StringBuilder res = new StringBuilder();
        res.append(stack.pop());
        while (!stack.isEmpty()) res.append(" ").append(stack.pop());
        return res.toString();
    }

    public static void main(String[] args) {
    }
}
