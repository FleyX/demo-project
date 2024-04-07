package com.fanxb.common.p100;

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

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode temp = null;
        //是否进位
        boolean jw = false;
        while (l1 != null || l2 != null) {
            if (temp == null) temp = res;
            else {
                temp.next = new ListNode(0);
                temp = temp.next;
            }
            if (l1 != null) {
                temp.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp.val += l2.val;
                l2 = l2.next;
            }
            if (jw) {
                temp.val += 1;
                jw = false;
            }
            if (temp.val >= 10) {
                jw = true;
                temp.val -= 10;
            }
        }
        if (jw) temp.next = new ListNode(1);
        return res;
    }


    public static void main(String[] args) {
    }
}
