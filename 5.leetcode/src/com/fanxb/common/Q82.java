package com.fanxb.common;

public class Q82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(), last = res, startBefore = null;
        res.next = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                if (startBefore == null)
                    startBefore = last;
                last = head;
            } else if (startBefore != null) {
                last = startBefore;
                startBefore.next = head.next;
                startBefore = null;
            } else {
                last = head;
            }
            head = head.next;
        }
        if (startBefore != null) startBefore.next = null;
        return res.next;
    }

    public ListNode better(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode cur = res.next, last = res;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int x = cur.next.val;
                while (cur != null && cur.val == x) {
                    last.next = cur.next;
                    cur = cur.next;
                }
            } else {
                last = cur;
                cur = cur.next;
            }
        }
        return res.next;

    }
}
