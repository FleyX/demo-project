package com.fanxb.common;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q264 {
    public int nthUglyNumber(int n) {
        int count = 1, res = 1;
        int[] uglyArr = new int[1690];
        uglyArr[0] = 1;
        int[] uglyIndex = {0, 0, 0};
        int[] values = {2, 3, 5};
        while (count < n) {
            int min = 0;
            for (int i = 1; i < 3; i++) {
                //找出三个中的最小值
                if (values[i] < values[min]) {
                    min = i;
                }
            }
            if (uglyArr[count - 1] < values[min]) {
                //数字不重复才记录
                uglyArr[count] = values[min];
                ;
            }
            uglyIndex[min]++;
            values[min] = min == 0 ? 2 * uglyArr[uglyIndex[min]] : min == 1 ? 3 * uglyArr[uglyIndex[min]] : 5 * uglyArr[uglyIndex[min]];
        }
        return uglyArr[count - 1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Q264().nthUglyNumber(16));

//        List<String> st<();
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Runnable runnable = () -> {
            try {
                System.out.println("我在运行,开始等待");
//                Object.wait();
                System.out.println("睡觉完了");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(2000);
        Thread.currentThread().notify();
    }
}
