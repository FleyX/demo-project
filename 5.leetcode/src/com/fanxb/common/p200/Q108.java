package com.fanxb.common.p200;

import com.fanxb.common.TreeNode;

public class Q108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, l, mid - 1);
        node.right = dfs(nums, mid + 1, r);
        return node;
    }


}
