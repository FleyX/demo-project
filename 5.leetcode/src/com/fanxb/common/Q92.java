package com.fanxb.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/9 15:10
 */
public class Q92 {

    public class ListNode {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        //node1 left位置前一个节点，node2 right位置后一个指针
        ListNode node1 = null, leftNode = null, node2 = null, rightNode = null;
        ListNode last = null, temp = head, next = null;
        int count = 0;
        while (temp != null) {
            count++;
            next = temp.next;
            if (left == count) {
                node1 = last;
                leftNode = temp;
            }
            if (right == count) {
                node2 = next;
                rightNode = temp;
            }
            if (count > left && count <= right) {
                temp.next = last;
            }

            last = temp;
            temp = next;
        }
        leftNode.next = node2;
        if (node1 != null) {
            node1.next = rightNode;
        } else {
            head = rightNode;
        }
        return head;
    }
}
