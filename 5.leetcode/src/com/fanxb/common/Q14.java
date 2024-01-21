package com.fanxb.common;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/10 10:49
 */
public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        StringBuilder res = new StringBuilder();
        int length = strs.length;
        int minLength = Stream.of(strs).map(String::length).min(Integer::compare).orElse(0);
        char a, b, c;
        for (int i = 0; i < minLength; i++) {
            for (int j = 1; j < length; j++) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) return res.toString();
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 1) return strs[0];
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < Math.min(res.length(), strs[i].length()); j++) {
                if (res.charAt(j) == strs[i].charAt(j)) temp.append(res.charAt(j));
                else break;
            }
            if (temp.length() == 0) return "";
            res = temp.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        Q14 instance = new Q14();
    }
}
