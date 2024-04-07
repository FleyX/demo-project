package com.fanxb.common.p300;

import java.util.PriorityQueue;

public class Q295 {
    private static class MedianFinder {
        //小于等于中位数的
        private PriorityQueue<Integer> l;
        //大于中位数的
        private PriorityQueue<Integer> r;


        public MedianFinder() {
            l = new PriorityQueue<>((a, b) -> b - a);
            r = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            if (l.size() == r.size()) {
                if (r.isEmpty()) l.add(num);
                else if (r.peek() >= num) l.add(num);
                else {
                    l.add(r.poll());
                    r.add(num);
                }
            } else {
                if (l.peek() <= num) {
                    r.add(num);
                } else {
                    r.add(l.poll());
                    l.add(num);
                }
            }
        }

        public double findMedian() {
            return l.size() == r.size() ? (l.peek() + r.peek()) / 2.0 : l.peek();
        }
    }
}
