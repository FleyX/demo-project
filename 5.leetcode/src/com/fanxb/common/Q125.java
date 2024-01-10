package com.fanxb.common;

/**
 * 题目地址： https://leetcode-cn.com/problems/partition-labels/
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q125 {

    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i=0,j=chars.length-1;
        while (i<j){
            char ci = chars[i];
            if(!isOk(ci)) {
                i++;
                continue;
            }
            char cj = chars[j];
            if(!isOk(cj)){
                j--;
                continue;
            }
            if(ci !=cj) return false;
            i++;j--;
        }
        return true;
    }

    private boolean isOk(char ci){
        return (ci>='a' && ci<='z') || (ci>='0' && ci<='9');
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
    }
}
