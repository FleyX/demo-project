package com.fanxb.common;

public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(), index = head;
        res.next = head;
        int count = 0;
        //left:开始翻转节点的父节点
        //right:结束翻转的节点
        ListNode beforeL = res, l = beforeL.next, r, afterR;
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
    private void reverse(ListNode start, int n) {
        //反转节点
        ListNode prev = null;
        for (int i = 0; i < n; i++) {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        new Q25().reverseKGroup(node, 3);
    }
}
