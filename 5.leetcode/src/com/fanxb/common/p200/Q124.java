package com.fanxb.common.p200;

import com.fanxb.common.TreeNode;

public class Q124 {
    private int resValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxValue(root);
        return resValue;
    }

    public int maxValue(TreeNode node) {
        if (node == null) return 0;
        int leftValue = Math.max(maxValue(node.left), 0);
        int rightValue = Math.max(maxValue(node.right), 0);
        //自身作为路径最高节点时的记过，左右子树都能用到
        resValue = Math.max(resValue, node.val + leftValue + rightValue);
        //返回自身作为非路径最高点时，能提供的最大值
        return node.val + Math.max(leftValue, rightValue);

    }
}
