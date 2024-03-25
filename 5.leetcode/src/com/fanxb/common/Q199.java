package com.fanxb.common;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author fanxb
 * @date 2021-08-31-下午4:50
 */
public class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, Integer> res = new LinkedHashMap<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        int depth = 0;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            while (size-- > 0) {
                TreeNode node = linkedList.pollFirst();
                res.put(depth, node.val);
                if (node.left != null) linkedList.addLast(node.left);
                if (node.right != null) linkedList.addLast(node.right);
            }
            depth++;
        }
        return new ArrayList<>(res.values());
    }


}
