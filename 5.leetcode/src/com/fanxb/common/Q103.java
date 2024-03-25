package com.fanxb.common;

import java.util.*;

public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (!leftToRight) Collections.reverse(temp);
            res.add(temp);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
