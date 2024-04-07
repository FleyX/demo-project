package com.fanxb.common.p200;

/**
 * TODO
 *
 * @author fanxb
 * @date 2022/3/7 10:48
 */
public class Q148 {

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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //中间节点的下一个节点
        ListNode slowNext = slow.next;
        //从中间断开链表
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slowNext);
        //左右节点进行二路归并
        ListNode res = new ListNode(), tempRes = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tempRes.next = left;
                left = left.next;
            } else {
                tempRes.next = right;
                right = right.next;
            }
            tempRes = tempRes.next;
        }
        tempRes.next = left == null ? right : left;
        return res.next;
    }

    public static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode mid = findMid(head);
            ListNode newMid = mid.next;
            mid.next = null;
            ListNode left = sortList(head), right = sortList(newMid);
            //左右进行归并排序
            ListNode res = new ListNode(0);
            ListNode temp = res;
            while (left != null && right != null) {
                if (left.val <= right.val) {
                    temp.next = left;
                    left = left.next;
                } else {
                    temp.next = right;
                    right = right.next;
                }
                temp = temp.next;
            }
            if (left != null) temp.next = left;
            else if (right != null) temp.next = right;
            return res.next;
        }

        private ListNode findMid(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }


    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        a1.next = new ListNode(2);
        a1.next.next = new ListNode(1);
        a1.next.next.next = new ListNode(3);
        System.out.println(new Q148().sortList(a1));
    }
}
