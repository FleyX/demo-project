package com.fanxb.common;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {
    private final int maxCount; // 最大数字
    private AtomicInteger count = new AtomicInteger(1);


    public Solution(int maxCount) {
        this.maxCount = maxCount;
    }

    // 开启两个线程分别打印奇数和偶数
    public void start() throws InterruptedException {
        // 线程 OddThread 调用 printOdd();
        Thread oddThread = new Thread(() -> {
            try {
                printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "OddThread");

        // 线程 EvenThread 调用 printEven();
        Thread evenThread = new Thread(() -> {
            try {
                printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "EvenThread");

        // 启动两个线程
        oddThread.start();
        evenThread.start();

        // 等待子线程执行完成
        oddThread.join();
        evenThread.join();
    }

    public void printOdd() throws InterruptedException {
        while (true) {
            while (count.get() <= maxCount && count.get() % 2 == 0) {
            }
            if (count.get() > maxCount) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-" + count);
            count.addAndGet(1);
        }
    }

    public void printEven() throws InterruptedException {
        while (true) {
            while (count.get() <= maxCount && count.get() % 2 == 1) {
            }
            if (count.get() > maxCount) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-" + count.get());
            count.addAndGet(1);
        }
    }

    static void main() throws Exception {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution(10);
        solution.start();

    }
}

