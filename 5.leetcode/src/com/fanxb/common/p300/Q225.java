package com.fanxb.common.p300;

import java.util.LinkedList;
import java.util.Queue;

public class Q225 {
    private Queue<Integer> queue1;

    public Q225() {
        this.queue1 = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue1.size();
        queue1.add(x);
        while (size-- > 0) {
            queue1.add(queue1.poll());
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
