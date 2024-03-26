package com.fanxb.common;

public class Q530 {
    private int res = Integer.MAX_VALUE;
    private Integer lastVal = null;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (lastVal != null) {
            res = Math.min(res, Math.abs(root.val - lastVal));
        }
        lastVal = root.val;
        dfs(root.right);
    }
}
