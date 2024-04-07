package com.fanxb.common.p100;

import com.fanxb.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94 {
    public List<Integer> inorderTraversal(com.fanxb.common.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<com.fanxb.common.TreeNode> stack = new Stack<>();
        stack.push(root);
        com.fanxb.common.TreeNode cur = root.left;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            cur = node.right;
        }
        return res;
    }
}
