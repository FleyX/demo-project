package com.fanxb.common.p100;

import java.util.*;
import java.util.stream.Collectors;

public class Q23 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        queue.addAll(Arrays.stream(lists).filter(Objects::nonNull).collect(Collectors.toList()));
        if (queue.isEmpty()) {
            return null;
        }
        ListNode res = queue.poll(), temp = res;
        while (!queue.isEmpty()) {
            if (temp.next != null) {
                queue.add(temp.next);
            }
            temp.next = queue.poll();
            temp = temp.next;
        }
        return res;
    }

    /**
     * 依次归并
     */
    public ListNode so1(ListNode[] lists) {
        List<ListNode> listNodeList = Arrays.stream(lists).filter(Objects::nonNull).collect(Collectors.toList());
        if (listNodeList.isEmpty()) {
            return null;
        }
        ListNode res = listNodeList.get(0);
        for (int i = 1; i < listNodeList.size(); i++) {
            //依次和第i合并
            ListNode tempRes = new ListNode(), temp = tempRes;
            ListNode cur = listNodeList.get(i);
            while (res != null && cur != null) {
                if (res.val < cur.val) {
                    temp.next = res;
                    res = res.next;
                } else {
                    temp.next = cur;
                    cur = cur.next;
                }
                temp = temp.next;
            }
            //接上剩下的部分
            temp.next = res == null ? cur : res;
            //临时结果
            res = tempRes.next;
        }
        return res;
    }

    public ListNode so2(ListNode[] lists) {
        List<ListNode> listNodeList = Arrays.stream(lists).filter(Objects::nonNull).collect(Collectors.toList());
        int n = listNodeList.size();
        if (n == 0) {
            return null;
        }
        while (n > 1) {
            int count = 0;
            for (int i = 0; i + 1 < n; i += 2, count++) {
                ListNode a = listNodeList.get(i), b = listNodeList.get(i + 1), head = new ListNode(), temp = head;
                while (a != null && b != null) {
                    if (a.val < b.val) {
                        temp.next = a;
                        a = a.next;
                    } else {
                        temp.next = b;
                        b = b.next;
                    }
                    temp = temp.next;
                }
                temp.next = a == null ? b : a;
                listNodeList.set(count, head.next);
            }
            //如果为奇数，要把最后一个落单的放到count上
            if (n % 2 != 0) {
                listNodeList.set(count++, listNodeList.get(n - 1));
            }
            //新的链表数量为count
            n = count;
        }
        return listNodeList.get(0);
    }

    public ListNode so3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return dfs(lists, 0, lists.length - 1);
    }

    private ListNode dfs(ListNode[] lists, int startI, int endI) {
        if (startI > endI) return null;
        if (startI == endI) return lists[startI];
        ListNode one, two;
        if (endI - startI > 1) {
            int mid = (startI + endI) / 2;
            one = dfs(lists, startI, mid);
            two = dfs(lists, mid + 1, endI);
        } else {
            one = lists[startI];
            two = lists[endI];
        }
        ListNode res = new ListNode();
        ListNode temp = res;
        while (one != null && two != null) {
            if (one.val <= two.val) {
                temp.next = one;
                one = one.next;
            } else {
                temp.next = two;
                two = two.next;
            }
            temp = temp.next;
        }
        if (one != null) temp.next = one;
        else if (two != null) temp.next = two;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);
        ListNode c = new ListNode(2);
        c.next = new ListNode(6);
//        new Q23().mergeKLists(new ListNode[]{a, b, c});
//        new Q23().so1(new ListNode[]{a, b, c});
        new Q23().so2(new ListNode[]{a, b});
    }
}
