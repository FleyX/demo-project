package com.fanxb.common.p100;

/**
 * Created with IntelliJ IDEA
 * 移除元素
 * 地址：https://leetcode-cn.com/problems/remove-element/
 * 思路：
 * 暴力办法，两层for循环，每找到一个相同元素就将后面的所有元素向前移动一位
 * 还有一种简便点的办法，不需要删除重复元素，只需要将重复元素替换为不重复元素即可
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q28 {
    public int strStr(String haystack, String needle) {
        int num1 = haystack.length(), num2 = needle.length();
        if (num2 == 0) {
            return 0;
        }
        for (int i = 0; i < num1; i++) {
            int count = 0;
            for (count = 0; count < num2 && i + count < num1; count++) {
                if (haystack.charAt(i + count) != needle.charAt(count)) {
                    break;
                }
            }
            if (count == num2) {
                return i;
            }
        }
        return -1;
    }

    public int kmp(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        //计算needle的PMT(部分匹配表)
        int[] pmt = new int[needle.length()];
        //从第二个字符开始计算
        for (int i = 1, j = 0; i < needle.length(); ) {
            if (needle.charAt(i) == needle.charAt(j)) {
                pmt[i] = j + 1;
                j++;
                i++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = pmt[j - 1];
                }
            }
        }

        for (int i = 0, j = 0; i < haystack.length(); ) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                if (j == 0) {
                    i++;
                } else {
                    j = pmt[j - 1];
                }
            } else {
                j++;
                i++;
            }
            if (j == needle.length()) {
                return i - needle.length();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q28().kmp("aabaaabaaac", "aabaaac"));
//        System.out.println(new Q28().kmp("hello", "ll"));
    }
}
