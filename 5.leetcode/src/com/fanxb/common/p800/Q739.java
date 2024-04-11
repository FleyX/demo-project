package com.fanxb.common.p800;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/11 10:58
 */
public class Q739 {
    public int[] dailyTemperatures(int[] T) {
        if (T.length == 0) {
            return new int[0];
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int j = 0;
            while (linkedList.size() > j && T[linkedList.get(j)] > T[i]) {
                j++;
            }
            linkedList.add(j, i);
            res[linkedList.get(j)] = i - linkedList.get(j);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q739().dailyTemperatures(new int[]{1, 2, 3})));
    }
}
