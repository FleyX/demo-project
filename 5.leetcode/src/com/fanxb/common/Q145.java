package com.fanxb.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Integer> helpStack = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            helpStack.push(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        while (!helpStack.isEmpty()) {
            res.add(helpStack.pop());
        }
        return res;
    }
}
