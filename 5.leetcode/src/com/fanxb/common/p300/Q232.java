package com.fanxb.common.p300;

import java.util.Stack;

/**
 * @author fanxb
 * @date 2021-08-31-下午4:50
 */
public class Q232 {

    public static void main(String[] args) {
        BetterMyQueue myQueue = new BetterMyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());

    }

    /**
     * main,每次push元素都放到main中，并把顺序排列好，方法是先把现有元素转移到help中，然后将新元素放到main里，再把help里的元素转移回来
     *
     * @author fanxb
     * @date 2021/8/31 下午5:08
     */
    private static class MyQueue {

        private Stack<Integer> main;
        private Stack<Integer> help;


        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            main = new Stack<>();
            help = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!main.isEmpty()) {
                help.push(main.pop());
            }
            main.push(x);
            while (!help.isEmpty()) {
                main.push(help.pop());
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return main.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return main.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return main.isEmpty();
        }
    }

    /**
     * @author fanxb
     * @date 2021/8/31 下午5:08
     */
    private static class BetterMyQueue {

        private Stack<Integer> input;
        private Stack<Integer> output;


        /**
         * Initialize your data structure here.
         */
        public BetterMyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            input.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (output.isEmpty()) {
                while (!input.empty()) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (output.isEmpty()) {
                while (!input.empty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return input.isEmpty();
        }
    }

}
