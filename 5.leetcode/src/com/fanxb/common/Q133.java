package com.fanxb.common;

import java.util.*;

public class Q133 {
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        Node temp = map.get(node);
        if (temp != null) return temp;
        temp = new Node(node.val, new ArrayList<>());
        map.put(node, temp);
        for (Node n : node.neighbors) {
            Node ng = dfs(n, map);
            temp.neighbors.add(ng);
        }
        return temp;
    }


    public Node cloneGraph1(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node res = new Node(node.val, new ArrayList<>());
        map.put(node, res);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            List<Node> list = map.get(temp).neighbors;
            for (Node n : temp.neighbors) {
                Node nc = map.get(n);
                if (nc == null) {
                    queue.add(n);
                    nc = new Node(n.val, new ArrayList<>());
                    map.put(n, nc);
                }
                list.add(nc);
            }
        }
        return res;
    }
}
