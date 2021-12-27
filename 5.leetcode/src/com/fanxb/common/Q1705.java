package com.fanxb.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a + days[a]));
        int res = 0, i = 0;
        //第一阶段,苹果还在长
        for (; i < days.length; i++) {
            //移除过期的苹果
            removeOutDate(days, priorityQueue, i);
            //加入新苹果
            if (apples[i] > 0) {
                priorityQueue.add(i);
            }
            //取一个苹果吃
            Integer index = priorityQueue.peek();
            if (index != null) {
                if (apples[index] == 1) {
                    //吃完的苹果移出队列
                    priorityQueue.poll();
                } else {
                    apples[index]--;
                }
                res++;
            }
        }
        //第二阶段,吃剩余的苹果
        for (; ; i++) {
            //移除过期苹果
            removeOutDate(days, priorityQueue, i);
            Integer index = priorityQueue.peek();
            if (index == null) {
                //没有苹果说明吃完了
                break;
            }
            if (apples[index] == 1) {
                //吃完的苹果移出队列
                priorityQueue.poll();
            } else {
                apples[index]--;
            }
            res++;
        }
        return res;
    }


    /**
     *
     */
    public void removeOutDate(int[] days, PriorityQueue<Integer> queue, int day) {
        Integer index;
        while ((index = queue.peek()) != null) {
            if ((index + days[index] - 1) < day) {
                queue.poll();
            } else {
                return;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Q1705().eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
    }
}
