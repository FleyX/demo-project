package com.fanxb.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 合并两个有序数组
 * 题目地址：https://leetcode-cn.com/problems/merge-sorted-array/
 * 解题思路：
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q142 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solution(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    public static ListNode betterSolution(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        //此时快慢指针相遇,再加一个指针c
        ListNode c = head;
        while (c != slow) {
            slow = slow.next;
            c = c.next;
        }
        return c;
    }


    public static void main(String[] args) {
        System.out.println();
    }
}
