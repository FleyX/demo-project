package com.fanxb.common;

/**
 * 两数相加
 *
 * @author fanxb
 * @date 2021/6/1
 **/
public class Q2 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverse(ListNode node) {
        ListNode last = null, cur = node, next = node.next;
        while (next != null) {
            cur.next = last;
            last = cur;
            cur = next;
            next = next.next;
        }
        cur.next = last;
        return cur;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode res = new ListNode(0), last = null, cur = res, next;
        while (l1 != null || l2 != null) {
            int val = cur.val;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (val >= 10) {
                cur.val = val - 10;
                next = new ListNode(1);
            } else {
                cur.val = val;
                next = new ListNode(0);
            }
            last = cur;
            cur.next = next;
            cur = next;
        }
        if (last != null && cur.val == 0) {
            last.next = null;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);

        new Q2().addTwoNumbers(l1, l2);
//        new Q2().addTwoNumbers(new ListNode(0), new ListNode(0));
    }
}
