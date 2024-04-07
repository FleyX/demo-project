package com.fanxb.common.p200;

import com.fanxb.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q173 {
    private static class BSTIterator {
        private LinkedList<TreeNode> nodes;
        private int i = 0;

        public BSTIterator(TreeNode root) {
            nodes = new LinkedList<>();
            readTree(root);
        }

        private void readTree(TreeNode root) {
            if (root == null) return;
            readTree(root.left);
            nodes.addLast(root);
            readTree(root.right);

        }

        public int next() {
            return nodes.pollFirst().val;
        }

        public boolean hasNext() {
            return !nodes.isEmpty();
        }
    }

    private static class BSTIterator1 {
        private Stack<TreeNode> stack;
        private TreeNode cur;

        public BSTIterator1(TreeNode root) {
            stack = new Stack<>();
            cur = root;
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            cur = node.right;
            return node.val;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
