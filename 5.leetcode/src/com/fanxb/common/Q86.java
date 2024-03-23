package com.fanxb.common;

public class Q86 {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode bigList = new ListNode(-1);
        ListNode pre = res, cur = head, bigCur = bigList;
        while (cur != null) {
            if (cur.val >= x) {
                bigCur.next = cur;
                bigCur = cur;
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        bigCur.next = null;
        pre.next = bigList.next;
        return res.next;
    }
}
