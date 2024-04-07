package com.fanxb.common.p200;

import com.fanxb.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
}
