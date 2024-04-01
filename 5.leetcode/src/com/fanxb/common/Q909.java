package com.fanxb.common;

import java.util.LinkedList;
import java.util.Queue;

public class Q909 {
    //记录走过的格子
    private int[][] cache;
    private int res = Integer.MAX_VALUE;

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{n - 1, 0});
//        int count
        while (!queue.isEmpty()) {
            Integer[] node = queue.poll();
        }
        return 0;
    }


}
