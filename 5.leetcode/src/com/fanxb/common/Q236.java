package com.fanxb.common;

import java.util.Stack;

/**
 * @author fanxb
 * @date 2021-08-31-下午4:50
 */
public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果当前root节点为p或者q中的一个，那么当前节点一定是最近的祖先
        if (root == null || root == p || root == q) return root;
        //分辨 在左右子树找p，q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            //两边都有找到，说明一个在左，一个在右,那么当前root节点一定是最近的祖先
            return root;
        }
        //左边找到了，右边没有
        if (left != null) return left;
        //左边没找到，一定是右边了
        return right;
    }
}
