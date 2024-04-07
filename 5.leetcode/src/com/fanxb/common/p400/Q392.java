package com.fanxb.common.p400;

/**
 * 两数相加
 *
 * @author fanxb
 * @date 2021/6/1
 **/
public class Q392 {
    public boolean isSubsequence(String s, String t) {
        int sLength=s.length(),tLength=t.length(),si=0,ti=0;
        while (si<sLength && ti<tLength){
            if(t.charAt(ti) == s.charAt(si)){
                si++;ti++;
                continue;
            }
            int i=ti+1;
            for(;i<tLength;i++){
                if(t.charAt(i)==s.charAt(si)){
                    ti = i+1;
                    si++;
                    break;
                }
            }
            if(i==tLength){
                si=0;
                ti++;
            }
        }
        return si>=sLength;
    }

    public static void main(String[] args) {
    }
}
