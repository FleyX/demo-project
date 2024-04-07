package com.fanxb.common.p300;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length, count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (citations[i] < count + 1) {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Q274().hIndex(new int[]{1, 3, 1}));
    }
}
