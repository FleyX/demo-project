package com.fanxb.common;

/**
 * 两数相加
 *
 * @author fanxb
 * @date 2021/6/1
 **/
public class Q877 {
    public boolean stoneGame(int[] piles) {
        int l=0,r=piles.length-1;
        long a=0,b=0;
        //是否a选择
        boolean aChange=true;
        while (l<=r){
            int res =piles[r]-piles[l];
            if (res <= 0) {
                //说明左边的不小于右边的
                if(aChange){
                    a+=piles[l++];
                }else{
                    b+=piles[l++];
                }
            }else{
                if(aChange){
                    a+=piles[r--];
                }else{
                    b+=piles[r--];
                }
            }
            aChange=!aChange;
        }
        return a>b;
    }
    public static void main(String[] args) {
        System.out.println(new Q877().stoneGame(new int[]{5,3,4,5}));
    }
}
