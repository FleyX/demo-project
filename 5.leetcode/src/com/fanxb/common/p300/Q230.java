package com.fanxb.common.p300;

import com.fanxb.common.TreeNode;

public class Q230 {
    private int res = 0;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.left, k);
        if (++count == k) {
            res = root.val;
        }
        dfs(root.right, k);
    }
}
