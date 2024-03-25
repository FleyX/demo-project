package com.fanxb.common;

public class Q222 {
    private int count = 0;

    public int countNodes(TreeNode root) {
        read(root);
        return count;
    }

    public void read(TreeNode root) {
        if (root == null) return;
        count++;
        read(root.left);
        read(root.right);
    }


    public int countNodes1(TreeNode root) {
        return count(root);
    }

    public int count(TreeNode root) {
        if (root == null) return 0;
        int lLevel = countLevel(root.left);
        int rLevel = countLevel(root.right);
        if (lLevel == rLevel) {
            //左右子树高度相同，说明左子树一定是满的
            return (int) Math.pow(2, lLevel) - 1 + count(root.right);
        } else {
            //高度不同，说明右子树一定是满的
            return (int) Math.pow(2, rLevel) - 1 + count(root.left);
        }
    }

    private int countLevel(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
