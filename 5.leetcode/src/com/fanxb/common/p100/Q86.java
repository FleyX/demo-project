package com.fanxb.common.p100;

import com.fanxb.common.ListNode;

public class Q86 {
    public com.fanxb.common.ListNode partition(com.fanxb.common.ListNode head, int x) {
        com.fanxb.common.ListNode res = new com.fanxb.common.ListNode(-1);
        res.next = head;
        com.fanxb.common.ListNode bigList = new com.fanxb.common.ListNode(-1);
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
