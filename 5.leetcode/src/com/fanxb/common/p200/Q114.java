package com.fanxb.common.p200;

import com.fanxb.common.TreeNode;

import java.util.LinkedList;

public class Q114 {
    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        read(root, nodes);
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).left = null;
            nodes.get(i).right = nodes.get(i + 1);
        }
    }

    public void read(TreeNode root, LinkedList<TreeNode> nodes) {
        if (root == null) return;
        else nodes.add(root);
        read(root.left, nodes);
        read(root.right, nodes);
    }

    public void flatten1(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode endRight = root.right;
            while (endRight.right != null) {
                endRight = endRight.right;
            }
            endRight.right = right;
        }
        flatten1(root.right);
    }


}
