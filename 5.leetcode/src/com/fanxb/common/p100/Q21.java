package com.fanxb.common.p100;

import com.fanxb.common.ListNode;

public class Q21 {
    public com.fanxb.common.ListNode mergeTwoLists(com.fanxb.common.ListNode list1, com.fanxb.common.ListNode list2) {
        if (list2 == null) return list1;
        if (list1 == null) return list2;
        com.fanxb.common.ListNode res = null;
        if (list1.val < list2.val) {
            res = list1;
            list1 = list1.next;
        } else {
            res = list2;
            list2 = list2.next;
        }
        ListNode temp = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) temp.next = list1;
        else temp.next = list2;
        return res;
    }
}
