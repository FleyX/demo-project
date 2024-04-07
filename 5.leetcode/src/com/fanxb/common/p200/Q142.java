package com.fanxb.common.p200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 * 题目地址:https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 解题思路：
 *   解法1：只要找到是否某个节点访问了两次即可，用set记录已访问过的节点，当访问的节点在set中说明找到了环形链表头，当节点没有下一个节点说明不存在环
 *   更优化的解法2：
 *     使用快慢指针，定义两个指针slow(慢指针，每次走1个)，fast(快指针，每次走两个),都从head出发。
 *     每进行一次移动fast和slow间隔的节点就会+1,由此可以推断当slow进入环后，一定会和fast相遇
 *     假设链表非环的长度为a,环的长度为b,fast走过的距离为f,slow走过的距离为s,当fast在环中循环n次后，fast,slow首次相遇，可得到如下表达式：
 *     f=2s(f的速度是s的两倍)
 *     f=s+nb(一定比s走的距离多n圈才会相遇)
 *     由上面两个得到：s=nb,由于s走的距离肯定包含了a,可以得到s在环中走的距离为nb-a,只需要继续走a的距离就能刚好走到环的起点。
 *     所以再加一个指针c从head开始，每次移动一格，当c和slow相遇时说明到了环的起点
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
