package com.fanxb.common.p200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanxb
 * @date 2021-09-17-下午11:13
 */
public class Q146 {
    private Map<Integer, Node> map;

    private int count;
    private int size;
    private Node head;
    private Node end;

    private static class Node {
        private int key;
        private int value;
        private Node next;
        private Node last;
    }

    public Q146(int capacity) {
        map = new HashMap<>(capacity);
        count = 0;
        size = capacity;
    }

    public int get(int key) {
        if (count == 0) {
            return -1;
        }
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveEndToHead(node);
        return node.value;
    }

    private void moveEndToHead(Node node) {
        if (node.last != null) {
            //说明非队首元素
            node.last.next = node.next;
            if (node.next != null) {
                //说明非队尾元素
                node.next.last = node.last;
            } else {
                //说明当前元素为队尾元素,需要修改end
                end = node.last;
            }
            //将node转移到队列头
            node.last = null;
            node.next = head;
            head.last = node;
            head = node;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            //同时把node移动到首位
            moveEndToHead(node);
        } else {
            if (count == size) {
                //说明需要排除队尾的元素
                map.remove(end.key);
                if (size == 1) {
                    head = null;
                    end = null;
                } else {
                    end = end.last;
                    end.next = null;
                }
                count--;
            }
            node = new Node();
            node.key = key;
            node.value = value;
            if (head != null) {
                head.last = node;
                node.next = head;
            } else {
                end = node;
            }
            head = node;
            count++;
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        Q146 q146 = new Q146(2);
        q146.put(2, 1);
        q146.put(1, 1);
        q146.put(2, 3);
        q146.put(4, 1);
        System.out.println(q146.get(1));
        System.out.println(q146.get(2));
//        q146.put(3, 2);
//        System.out.println(q146.get(2));
//        System.out.println(q146.get(3));
//        q146.put(4, 4);
//        System.out.println(q146.get(1));
//        System.out.println(q146.get(3));
//        System.out.println(q146.get(4));

    }
}
