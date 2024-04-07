package com.fanxb.common.p100;

/**
 * 旋转链表
 * 题目地址：https://leetcode-cn.com/problems/rotate-list/
 * 解题思路：
 * 关键需要找到链表的头，首先判断真正需要移动多少个位置（当k>=链表长度时会有很多无效的移动）,真实k=k%(链表长度),然后发现没每向右移动k位，相当于让倒数第k个节点变成头节点
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q61 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        ListNode[] lists = new ListNode[500];
        int count = 0;
        do {
            lists[count++] = head;
            head = head.next;
        } while (head != null);
        k = k % count;
        if (k == 0) {
            return lists[0];
        } else {
            lists[count - k - 1].next = null;
            lists[count - 1].next = lists[0];
            return lists[count - k];
        }

    }


    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        rotateRight(node, 2);
    }
}
