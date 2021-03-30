package com.fanxb.common;

import java.util.*;

/**
 * 题目地址： https://leetcode-cn.com/problems/partition-labels/
 * 解题思路：首先遍历一次字符串，记录每个字母最后出现的位置
 * 然后再遍历一遍，记录当前字符串的开始位置start,结束位置end. 当第i个字母的结束位置》end时end=第i个字母的结束位置，知道i=end说明当前位置为字符串的结束位置
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q763 {

    public static List<Integer> solution(String S) {
        List<Integer> res = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>(24);
        char[] chars = new char[S.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = S.charAt(i);
            map.put(chars[i], i);
        }
        int start = 0, end = map.get(chars[0]), temp;
        for (int i = 0; i < chars.length; i++) {
            if ((temp = map.get(chars[i])) > end) {
                //中间的某个点最远出现的位置大于end,说明当前字符串的结束点至少为end
                end = temp;
            } else if (i == end) {
                res.add(end - start + 1);
                //进行下一段的搜索
                start = end + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "eaaaabaaec";
        System.out.println(solution(S));
    }
}
