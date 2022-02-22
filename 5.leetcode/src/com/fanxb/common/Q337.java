package com.fanxb.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 旋转链表
 * 题目地址：https://leetcode-cn.com/problems/assign-cookies/submissions/
 * 解题思路：
 * 贪心算法，想不明白
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q337 {


    public int rob(TreeNode root) {
        return robDo(root, new HashMap<>());
    }

    public int robDo(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        Integer val = map.get(root);
        if (val != null) {
            return val;
        }
        //从根节点看起，根节点如果选择投了钱那么他的两个子节点都不能投钱，此是偷的钱的和为根节点的钱+从根节点孙子结点开始偷的钱的综合
        //如果根节点不偷，那么他的两个子节点都可以投钱，此时偷钱的和为从两个子节点开始偷到的钱的综合
        //然后再把子节点当作根节点来看就得到了递归关系
        //sum1:两个孩子节点能偷到的钱
        int sum1 = robDo(root.left, map) + robDo(root.right, map);
        //四个孙子和roo节点能偷盗的钱
        int sum2 = root.val + (root.left == null ? 0 : (robDo(root.left.left, map) + robDo(root.left.right, map))) + (root.right == null ? 0 : (robDo(root.right.left, map) + robDo(root.right.right, map)));
        val = Math.max(sum1, sum2);
        map.put(root, val);
        return val;
    }


    public static void main(String[] args) {
    }
}
