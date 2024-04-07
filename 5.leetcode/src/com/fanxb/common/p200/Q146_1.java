package com.fanxb.common.p200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author fanxb
 * @date 2021-09-17-下午11:13
 */
public class Q146_1 {
    private static class LRUCache {
        private static class Node {
            private Node last;
            private Node next;
            private int key;
            private int value;

            public Node() {

            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        int capacity;
        int count;
        Node head;
        Node end;
        Node[] cache;

        LRUCache(int capacity) {
            this.capacity = capacity;
            this.count = 0;
            head = new Node();
            end = new Node();
            head.next = end;
            end.last = head;
            cache = new Node[10001];
        }

        int get(int key) {
            Node node = cache[key];
            if (node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        void put(int key, int value) {
            Node node = cache[key];
            if (node != null) {
                moveToHead(node);
                node.value = value;
                return;
            }
            node = new Node(key, value);
            cache[key] = node;
            node.last = head;
            node.next = head.next;
            head.next.last = node;
            head.next = node;
            count++;
            if (count > capacity) {
                cache[end.last.key] = null;
                end.last = end.last.last;
                end.last.next = end;
                count--;
            }
        }

        void moveToHead(Node node) {
            node.next.last = node.last;
            node.last.next = node.next;
            node.next = head.next;
            node.last = head;
            head.next.last = node;
            head.next = node;
        }
    }


    public static void main(String[] args) {
    }
}
