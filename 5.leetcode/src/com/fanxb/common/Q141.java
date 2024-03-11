package com.fanxb.common;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author FleyX
 * @date 2022/3/3 22:35
 */
public class Q141 {
    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
