package com.fanxb.common;

import java.util.Arrays;

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

    public static void quickSort(int[] arr, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int l = start, r = end, base = arr[start];
        while (l < r) {
            //右边找到一个小于base的然后交换
            while (arr[r] >= base && l < r) {
                r--;
            }
            //左边找到一个大于base的
            while (arr[l] <= base && l < r) {
                l++;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        //交换start和i的位置，使base左边的都小于等于base,右边的都大于等于base
        arr[start] = arr[l];
        arr[l] = base;

        //对l左边和右边的分别进行快拍
        quickSort(arr, start, l - 1);
        quickSort(arr, l + 1, end);
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


    public static void main(String[] args) {
        int[] s = {23, 49, 13, 12, 45, 393, 21, 21048, 12};
//        System.out.println(Arrays.toString(sort1(s)));
//        quickSort(s, 0, s.length - 1);
        insertSort(s);
        System.out.println(Arrays.toString(s));
    }
}
