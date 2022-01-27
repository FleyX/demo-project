package com.fanxb.common;

public class Q19 {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        //先将p,q的距离差拉到n,这样当q在结尾时，刚好p在倒数第n+1个位置上，删除下一个位置即可
        while ((n--) > 0) {
            q = q.next;
        }
        //考虑特殊情况，当n等于链表长度时，需要删除第一个元素
        if (q == null) {
            return p.next;
        }
        //让q走到结尾
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        //删除p的下一个节点
        p.next = p.next.next;
        return head;

    }
}
