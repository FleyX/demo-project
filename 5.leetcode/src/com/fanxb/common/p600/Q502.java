package com.fanxb.common.p600;

import java.util.*;

public class Q502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        List<int[]> list = new ArrayList<>(profits.length);
        for (int i = 0; i < profits.length; i++) list.add(new int[]{profits[i], capital[i]});
        list.sort(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>(profits.length, (a, b) -> b - a);
        int temp = 0;
        while (k-- > 0) {
            while (temp < profits.length && list.get(temp)[1] <= w) {
                queue.add(list.get(temp)[0]);
                temp++;
            }
            if (queue.isEmpty()) return w;
            w += queue.poll();
        }
        return w;

    }
}
