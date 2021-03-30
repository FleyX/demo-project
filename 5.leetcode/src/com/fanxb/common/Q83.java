package com.fanxb.common;

/**
 * TODO 类描述
 *
 * @author fanxb
 * @date 2021/3/26
 **/
public class Q83 {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }

        }
        return head;
    }

    /**
     * 递归版块
     *
     * @param head head
     * @return com.fanxb.common.Q83.ListNode
     * @author fanxb
     * @date 2021/3/26
     **/
    public ListNode deleteDuplicatesRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        head.next = deleteDuplicatesRecursion(head.next);
        if (head.next.val == head.val) {
            return head.next.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }

}
