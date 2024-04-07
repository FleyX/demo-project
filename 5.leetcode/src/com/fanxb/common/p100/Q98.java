package com.fanxb.common.p100;

import com.fanxb.common.TreeNode;

public class Q98 {
    private Integer lastVal = null;

    public boolean isValidBST(com.fanxb.common.TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) return true;
        boolean left = dfs(root.left);
        if (lastVal != null && lastVal >= root.val) {
            return false;
        }
        lastVal = root.val;
        boolean right = dfs(root.right);
        return left && right;
    }
}
