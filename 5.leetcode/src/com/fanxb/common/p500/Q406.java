package com.fanxb.common.p500;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 题目地址：
 * 解题思路：
 *
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q406 {

    public static int[][] solution(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(b[0], a[0]);
            }
        });
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] person : people) {
            if (person[1] >= res.size()) {
                res.add(person);
            } else {
                res.add(person[1], person);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(solution(people)));
    }
}
