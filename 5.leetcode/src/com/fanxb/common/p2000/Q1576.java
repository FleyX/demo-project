package com.fanxb.common.p2000;

public class Q1576 {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        //相对于a的asii值
        int last, next;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '?') {
                continue;
            }
            last = i == 0 ? -1 : chars[i - 1] - 'a';
            next = i == chars.length - 1 || chars[i + 1] == '?' ? -1 : chars[i + 1] - 'a';
            if (last == -1) {
                if (next == -1) {
                    chars[i] = 'a';
                } else {
                    chars[i] = (char) ((next + 1) % 26 + 'a');
                }
            } else {
                if (next == -1) {
                    chars[i] = (char) ((last + 1) % 26 + 'a');
                } else {
                    int big = Math.max(last, next);
                    int less = Math.min(last, next);
                    chars[i] = (char) (big - less > 1 ? ('a' + less + 1) : ('a' + (big + 1) % 26));
                }
            }
        }
        return new String(chars);
    }
}
