package com.fanxb.common.p300;

import java.util.*;

public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //记录课程的入度
        int[] inCount = new int[numCourses];
        //记录课程的后续课程
        Map<Integer, List<Integer>> nextCourses = new HashMap<>(numCourses);
        for (int[] pre : prerequisites) {
            inCount[pre[0]]++;
            List<Integer> next = nextCourses.computeIfAbsent(pre[1], k -> new ArrayList<>());
            next.add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inCount[i] == 0) queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int c = queue.poll();
            count++;
            List<Integer> next = nextCourses.get(c);
            if (next == null) continue;
            next.forEach(item -> {
                inCount[item]--;
                if (inCount[item] == 0) queue.offer(item);
            });
        }
        return numCourses == count;
    }

    public static void main(String[] args) {
        new Q207().canFinish(2, new int[][]{{0, 1}});
    }
}
