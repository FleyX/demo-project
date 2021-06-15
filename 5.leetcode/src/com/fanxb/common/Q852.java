package com.fanxb.common;

/**
 * 两数相加
 *
 * @author fanxb
 * @date 2021/6/1
 **/
public class Q852 {
    public int peakIndexInMountainArray(int[] arr) {
        int l=0,r=arr.length-1;
        while (l<r){
            int mid = l+(r-l)/2;
            if(arr[mid]==arr[mid+1]){
                //无法判断mid处于什么位置
                if(arr[l]<=arr[mid]){
                    l++;
                }else{
                    r--;
                }
            }else if(arr[mid]>arr[mid+1]){
                //说明是递减的
                r=mid;
            }else{
                //说明是递增的
                l=mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Q852().peakIndexInMountainArray(new int[]{0,10,5,2}));
    }
}
