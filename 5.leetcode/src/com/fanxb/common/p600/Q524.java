package com.fanxb.common.p600;

import java.util.Arrays;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 * 地址： https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * 思路：
 * 1. 返回长度最长且字典顺序最小的字符串,首先需要对字符串进行排序，这样就不需要扫描所有的字符串了，返回第一个符合要求的即可
 * 2. 使用两个指针，i指向s的开头，j指向目标字符串item的开头
 * 3. 如果s[i++]!=item[j]说明要删除i位置的字符，否则j++,并判断j是否到达item末尾，到达说明item符合要求。
 *
 *
 * @author fanxb
 * @date 2021/4/3
 **/
public class Q524 {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return b.length() - a.length();
            }
        });
        for (String item : dictionary) {
            if (s.length() < item.length()) {
                continue;
            }
            int i = 0, j = 0;
            while (i < s.length() && s.length() - i >= item.length() - j) {
                if (s.charAt(i) == item.charAt(j)) {
                    j++;
                    if (j == item.length()) {
                        return item;
                    }
                }
                i++;
            }

        }
        return "";
    }

    public static void main(String[] args) {
        Q524 q = new Q524();
        System.out.println(q.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }
}
