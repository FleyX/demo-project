package com.fanxb.common.p400;

/**
 * 两数相加
 *
 * @author fanxb
 * @date 2021/6/1
 **/
public class Q383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[128];
        for (int i = 0; i < magazine.length(); i++) {
            charCount[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (charCount[c] == 0)
                return false;
            charCount[c]--;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
