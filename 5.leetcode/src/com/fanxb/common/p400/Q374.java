package com.fanxb.common.p400;

/**
 * 两数相加
 *
 * @author fanxb
 * @date 2021/6/1
 **/
public class Q374 {
    private static int target=6;
    private static int guess(int num){
        return Integer.compare(target, num);
    }

    public int guessNumber(int n) {
        int l=1,r=n;
        while (l<r){
            int mid = l+(r-l)/2;
            if(guess(mid)==1){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Q374().guessNumber(10));
    }
}
