package com.fanxb.common.p100;

import com.fanxb.common.ListNode;

public class Q25 {
    public com.fanxb.common.ListNode reverseKGroup(com.fanxb.common.ListNode head, int k) {
        com.fanxb.common.ListNode res = new com.fanxb.common.ListNode(), index = head;
        res.next = head;
        int count = 0;
        //left:开始翻转节点的父节点
        //right:结束翻转的节点
        com.fanxb.common.ListNode beforeL = res, l = beforeL.next, r, afterR;
        while (index != null) {
            if (++count == k) {
                //进行翻转
                r = index;
                afterR = index.next;
                reverse(l, count);
                index = l;
                //处理头尾节点关系
                l.next = afterR;
                beforeL.next = r;
                //进行下一轮循环
                beforeL = index;
                l = index.next;
                count = 0;
            }
            index = index.next;
        }
        return res.next;
    }

    /**
     * 翻转start后的n个节点
     *
     * @param start
     * @param n
     */
    private void reverse(com.fanxb.common.ListNode start, int n) {
        //反转节点
        com.fanxb.common.ListNode prev = null;
        for (int i = 0; i < n; i++) {
            com.fanxb.common.ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
    }

    public com.fanxb.common.ListNode newReverseKGroup(com.fanxb.common.ListNode head, int k) {
        if (k == 1) return head;
        boolean firstDeal = true;
        int count = 0;
        com.fanxb.common.ListNode res = head, left = null, right, lastRight = null;
        while (head != null) {
            if (left == null) left = head;
            count++;
            if (count == k) {
                right = head;
                reverse(left, right);
                if (firstDeal) {
                    res = right;
                    firstDeal = false;
                } else {
                    lastRight.next = right;
                }
                lastRight = left;
                head = left.next;
                left = null;
                count = 0;
            } else {
                head = head.next;
            }
        }
        return res;
    }

    private void reverse(com.fanxb.common.ListNode start, com.fanxb.common.ListNode end) {
        com.fanxb.common.ListNode last = start, current = start.next, next, temp = end.next;
        while (current != null && current != temp) {
            next = current.next;
            current.next = last;
            last = current;
            current = next;
        }
        start.next = temp;
    }


    public com.fanxb.common.ListNode new1ReverseKGroup(com.fanxb.common.ListNode head, int k) {
        com.fanxb.common.ListNode res = new com.fanxb.common.ListNode(0);
        res.next = head;
        com.fanxb.common.ListNode pre = res, next;
        while (head != null) {
            com.fanxb.common.ListNode end = head;
            for (int i = 0; i < k - 1 && end != null; i++) end = end.next;
            if (end == null) break;
            next = end.next;
            end.next = null;
            pre.next = end;
            reverse1(head);
            head.next = next;
            pre = head;
            head = head.next;
        }
        return res.next;
    }

    public com.fanxb.common.ListNode reverse1(com.fanxb.common.ListNode head) {
        com.fanxb.common.ListNode pre = head, cur = head.next, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        com.fanxb.common.ListNode node = new com.fanxb.common.ListNode(1);
        node.next = new com.fanxb.common.ListNode(2);
        node.next.next = new com.fanxb.common.ListNode(3);
        node.next.next.next = new com.fanxb.common.ListNode(4);
        node.next.next.next.next = new ListNode(5);
        new Q25().new1ReverseKGroup(node, 2);
    }
}
