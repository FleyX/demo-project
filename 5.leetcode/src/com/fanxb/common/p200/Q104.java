package com.fanxb.common.p200;

public class Q104 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left, 2), maxDepth(root.right, 2));
    }

    public int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }
}
