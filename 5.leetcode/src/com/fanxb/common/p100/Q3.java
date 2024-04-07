package com.fanxb.common.p100;

import java.util.*;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int res = 0;
        //存储当前结果子串
        LinkedList<Character> characters = new LinkedList<>();
        //字符对应characters中的index
        boolean[] existArr = new boolean[128];
        characters.add(s.charAt(0));
        existArr[s.charAt(0)] = true;
        for (int i = 1; i < s.length(); i++) {
            Character one = s.charAt(i);
            if (existArr[one]) {
                //这个字符出现过,当前的长度就是目前能找到的最大长度
                res = Math.max(res, characters.size());
                //去掉重复字符及该字符之前的所有字符
                while (true) {
                    Character temp;
                    if ((temp = characters.poll()) == one) {
                        break;
                    }
                    existArr[temp] = false;
                }
                //将当前字符串加入
                characters.add(one);
            } else {
                //这个字符没出现过，可以加到characters中
                characters.add(one);
                existArr[one] = true;
            }
        }
        return Math.max(characters.size(), res);
    }

    public int lengthOfLongestSubstring1(String s) {
        int l = 0, r = 0, length = s.length();
        int[] map = new int[129];
        int res = 0;
        while (r < length) {
            char c = s.charAt(r);
            boolean has = map[c] == 1;
            if (has) {
                res = Math.max(res, r - l);
                //遇到重复的，把l右移直到排除掉重复的
                while (true) {
                    char c1 = s.charAt(l);
                    map[c1] = 0;
                    l++;
                    if (c1 == c) break;
                }
            } else if (r == length - 1) {
                res = Math.max(res, r - l + 1);
            }
            map[c] = 1;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q3().lengthOfLongestSubstring1("abcabcbb"));
    }
}
