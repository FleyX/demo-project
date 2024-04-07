package com.fanxb.common.p200;

import java.util.LinkedList;

public class Q155 {
    private LinkedList<Integer[]> stack = new LinkedList<>();

    public Q155() {

    }

    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(stack.getFirst()[1], val);
        stack.push(new Integer[]{val, min});
    }

    public void pop() {
        stack.removeFirst();
    }

    public int top() {
        return stack.getFirst()[0];
    }

    public int getMin() {
        return stack.getFirst()[1];
    }
}
