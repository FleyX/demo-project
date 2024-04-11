package com.fanxb.common.p2000;

import java.util.Arrays;

/**
 * Date: 2020/6/9 15:10
 */
public class Q1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] daySum = new long[candiesCount.length];
        long sum = 0;
        for (int i = 0; i < candiesCount.length; i++) {
            sum += candiesCount[i];
            daySum[i] = sum;
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            long maxNum = (long) query[2] * (query[1] + 1);
            if (maxNum >= daySum[query[0]]) {
                res[i] = (query[1] + 1) <= daySum[query[0]];
            } else {
                res[i] = query[0] == 0 || maxNum > daySum[query[0] - 1];
            }
        }
        return res;
    }


    public static void main(String[] args) {

//        System.out.println(Arrays.toString(new Q1744().canEat(new int[]{}
//                , new int[][]{{48942, 869704869, 212630006}})));
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        Node last = null, current = a, next = a.next;
        while (current.next != null) {
            current.next = last;
            last = current;
            current = next;
            next = next.next;
        }
        current.next = last;
    }

    public static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
