package com.fanxb.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q117 {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        LinkedList<Node> list = new LinkedList<>();
        list.addFirst(root);
        while (!list.isEmpty()) {
            int size = list.size();
            while (size-- > 0) {
                Node node = list.removeLast();
                if (size != 0) node.next = list.peekLast();
                if (node.left != null) list.addFirst(node.left);
                if (node.right != null) list.addFirst(node.right);

            }
        }
        return root;
    }

    public Node connect1(Node root) {
        if (root == null) return null;
        Node cur = root;
        while (cur != null) {
            Node temp = cur, start = new Node(), end = start;
            while (temp != null) {
                if (temp.left != null) {
                    end.next = temp.left;
                    end = end.next;
                }
                if (temp.right != null) {
                    end.next = temp.right;
                    end = end.next;
                }
                temp = temp.next;
            }
            cur = start.next;
        }
        return root;
    }
}
