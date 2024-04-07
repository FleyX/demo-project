package com.fanxb.common.p200;

import com.fanxb.common.TreeNode;

public class Q129 {
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

    private int res = 0;

    public int sumNumbers(TreeNode root) {
        deal(root, 0);
        return res;
    }

    private void deal(TreeNode root, int cur) {
        if (root == null) return;
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += cur;
        }
        deal(root.left, cur);
        deal(root.right, cur);
    }
}
