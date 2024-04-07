package com.fanxb.common.p300;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q278 {
    private boolean isBadVersion(int n){
        return true;
    }

    public int firstBadVersion(int n) {
        int left=1,right=n;
        while (left<right){
            int mid =(int) ((long)left+right>>1);
            if(isBadVersion(mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Q278().firstBadVersion(16));
    }
}
