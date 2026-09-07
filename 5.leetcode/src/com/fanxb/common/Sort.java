package com.fanxb.common;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 排序
 *
 * @author fanxb
 * @date 2021/4/4
 **/
public class Sort {

    /**
     * 冒泡排序
     *
     * @author fanxb
     * @date 2021/4/4
     **/
    public static int[] sort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0, length = arr.length - 1 - i; j < length; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private static Random random = new Random();

    /**
     * 快排
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        if(start>=end){
            return;
        }
//        int k = random.nextInt(start,end);
        int k=0;
        swap(arr,start,k);
        int val = arr[start],i=start,j=end;
        while (i<j){
            while (i<j && arr[j]>=val){
                j--;
            }
            while (i<j && arr[i]<=val){
                i++;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,start,i);
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i]=temp;
    }

    /**
     * 插入排序
     *
     * @author fanxb
     * @date 2021/4/4
     **/
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 && arr[j - 1] > arr[j]; j--) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }
    }



    /**
     * 归并排序
     * @param arr
     */
    public static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] nums,int l,int r,int[] temp){
        if(l>=r){
            return;
        }
        int mid = (l+r)/2;
        mergeSort(nums,l,mid,temp);
        mergeSort(nums,mid+1,r,temp);
        merge(nums,l,r,mid,temp);
    }

    private static void merge(int[] nums,int l,int r,int mid,int[] temp){
        int count=0,lStart=l,rStart=mid+1;
        while(lStart<=mid && rStart<=r){
            if(nums[lStart]<=nums[rStart]){
                temp[count++]=nums[lStart++];
            }else{
                count+=mid-lStart+1;
                temp[count++]=nums[rStart++];
            }
        }
        while(lStart<=mid){
            temp[count++]=nums[lStart++];
        }
        while(rStart<=r){
            temp[count++]=nums[rStart++];
        }
        for(int i=0;i<count;i++){
            nums[l+i]=temp[i];
        }
    }


    public static void main(String[] args) {
        int[] s = {23, 49, 13, 12, 45, 393, 21, 21048, 12};
//        System.out.println(Arrays.toString(sort1(s)));
        quickSort(s, 0, s.length - 1);
//        insertSort(s);
//        mergeSort(s);
        System.out.println(Arrays.toString(s));
    }
}
