package com.fanxb.common.p200;

import com.fanxb.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, map, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] pre, Map<Integer, Integer> map, int pL, int pR, int iL, int iR) {
        if (pL > pR || iL > iR) return null;
        TreeNode root = new TreeNode(pre[pR]);
        int index = map.get(pre[pR]);
        System.out.println(index);
        int newPr = pL + index - iL - 1;
        root.left = buildTree(pre, map, pL, newPr, iL, index - 1);
        root.right = buildTree(pre, map, newPr + 1, pR - 1, index + 1, iR);
        return root;
    }

}
