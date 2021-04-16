package com.fanxb.common;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * x 的平方根
 * 地址： https://leetcode-cn.com/problems/sqrtx/
 * 思路： 题目要求求解一个数的平方根的整数部分，那就那就相当于找到一个数num,使其满足num*mum==x || num*num&lt;x && (num+1)*(num+1)>x
 * 可通过二分查找来进行求解，num的值一定是[0,x]中的一个数
 * 1. 首先设定l=0,r=x
 * 2. mid=(l+r)/2,temp1=mid*mid,temp2=(mid+1)*(mid+1)
 * 3. 如果temp1 == x || (temp1 < x && temp2 > x)满足结果即为mid
 * 4. 否则判断temp1>x,如果满足r=mid,重复2
 * 5. 否则l=mid,重复2
 *
 * @author fanxb
 * Date: 2020/6/11 9:56
 */
public class Q783 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        //找到左边的最大值和右边的最小值即可
        if (root.left != null) {
            TreeNode maxLeft = root.left;
            while (maxLeft.right != null) {
                maxLeft = maxLeft.right;
            }
            min = root.val - maxLeft.val;
            min = Math.min(min, minDiffInBST(root.left));
        }
        if (root.right != null) {
            TreeNode minRight = root.right;
            while (minRight.left != null) {
                minRight = minRight.left;
            }
            min = Math.min(min, minRight.val - root.val);
            min = Math.min(min, minDiffInBST(root.right));
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(90);
        root.left = new TreeNode(69);
        root.left.left = new TreeNode(49);
        root.left.right = new TreeNode(89);
        root.left.left.right = new TreeNode(52);
        System.out.println(new Q783().minDiffInBST(root));
    }
}
