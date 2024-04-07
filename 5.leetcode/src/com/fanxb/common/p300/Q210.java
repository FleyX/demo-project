package com.fanxb.common.p300;

import java.util.*;

public class Q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //课程入度统计
        int[] courseCount = new int[numCourses];
        //记录一门课上完以后接着可以上哪些课
        Map<Integer, List<Integer>> nextCourseMap = new HashMap<>(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            int[] temp = prerequisites[i];
            courseCount[temp[0]]++;
            nextCourseMap.computeIfAbsent(temp[1], k -> new ArrayList<>()).add(temp[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < courseCount.length; i++) {
            if (courseCount[i] == 0) queue.offer(i);
        }
        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            res[count++] = course;
            nextCourseMap.getOrDefault(course, new ArrayList<>(0)).forEach(item -> {
                courseCount[item]--;
                if (courseCount[item] == 0) {
                    queue.offer(item);
                }
            });
        }
        return count == numCourses ? res : new int[0];
    }
}
