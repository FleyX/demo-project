package com.fanxb.common.p200;

import com.fanxb.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(preorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> map, int pL, int pR, int iL, int iR) {
        if (pL > pR) return null;
        TreeNode root = new TreeNode(preorder[pL]);
        int rs = map.get(root.val);
        //前序左边子树结束位置
        int newPr = pL + rs - iL;
        root.left = buildTree(preorder, map, pL + 1, newPr, iL, rs - 1);
        root.right = buildTree(preorder, map, newPr + 1, pR, rs + 1, iR);
        return root;
    }
}
