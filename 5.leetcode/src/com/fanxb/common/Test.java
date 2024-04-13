package com.fanxb.common;

import java.util.Arrays;

public class Test {

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int base = array[start];
        int l = start, r = end;
        while (l < r) {
            while (array[r] >= base && r > l) r--;
            while (array[l] <= base && l < r) l++;
            if (l < r) swap(array, l, r);
        }
        swap(array, start, l);
        quickSort(array, start, l - 1);
        quickSort(array, l + 1, end);
    }

    private void bubble(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j + 1] < array[j]) swap(array, j + 1, j);
            }
        }
    }

    private void insert(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) swap(array, j, j - 1);
        }
    }

    private void swap(int[] array, int a, int b) {
        if (a == b) return;
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    private void shell(int[] array, int a) {
        if (a <= 0) return;
        int n = array.length;
        for (int i = 0; i < a; i++) {
            for (int j = i + a; j < n; j += a) {
                for (int k = j; k > i && array[k] < array[k - a]; k -= a) swap(array, k, k - a);
            }
        }
        shell(array, a / 2);
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] arr = new int[]{1, 53, 12, 4344, 112, -22, 333211, 3333, 444, 55511, 121};
//        test.quickSort(arr, 0, arr.length - 1);
//        test.bubble(arr);
        test.insert(arr);
//        test.shell(arr, arr.length / 2);
        System.out.println(Arrays.toString(arr));
    }

    Object object =new Object();
}
