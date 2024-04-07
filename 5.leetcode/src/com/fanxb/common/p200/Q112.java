package com.fanxb.common.p200;

import com.fanxb.common.TreeNode;

import java.util.LinkedList;

public class Q112 {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathSum(root, targetSum, 0);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int curSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum == curSum + root.val;
        }
        int sum = root.val + curSum;
        if (sum > targetSum) return false;
        return hasPathSum(root.left, targetSum, sum) || hasPathSum(root.right, targetSum, sum);
    }


}
