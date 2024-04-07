package com.fanxb.common.p100;

import com.fanxb.common.ListNode;

public class Q82 {
    public com.fanxb.common.ListNode deleteDuplicates(com.fanxb.common.ListNode head) {
        if (head == null || head.next == null) return head;
        com.fanxb.common.ListNode res = new com.fanxb.common.ListNode(), last = res, startBefore = null;
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

    public com.fanxb.common.ListNode better(com.fanxb.common.ListNode head) {
        com.fanxb.common.ListNode res = new com.fanxb.common.ListNode();
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
