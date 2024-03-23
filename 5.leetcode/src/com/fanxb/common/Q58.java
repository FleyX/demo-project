package com.fanxb.common;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q58 {

    public int lengthOfLastWord(String s) {
        int count = 0, length = s.length();
        boolean lastCharBlank = false;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                lastCharBlank = true;
            } else {
                if (lastCharBlank) count = 0;
                count++;
                lastCharBlank = false;
            }
        }
        return count;
    }

    public int lengthOfLastWord1(String s) {
        int length = s.length(), i;
        // find last word's first char index
        for (i = length - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') break;
        }
        // cal last word count
        for (int j = i - 1; j >= 0; j--) {
            if (s.charAt(j) == ' ') return i - j;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Q58().lengthOfLastWord("  asdfasdfasdf"));
    }
}
