package com.fanxb.common;

import java.util.Arrays;

/**
 * 验证回文字符串 Ⅱ
 * 题目地址：https://leetcode-cn.com/problems/valid-palindrome-ii/
 * 解题思路：先按照正常的回文数逻辑从两边向中间检查，直到发现不想等的一组字符，分辨判断删除左边或右边还是否为回文数
 *
 * @author fanxb
 * Date: 2021/04/03 15:10
 */
public class Q680 {

    public boolean check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public boolean solution(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return check(s, l + 1, r) || check(s, l, r - 1);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Q680 q = new Q680();
        System.out.println(q.solution("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
