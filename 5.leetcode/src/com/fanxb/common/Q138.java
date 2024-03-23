package com.fanxb.common;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author FleyX
 * @date 2022/3/3 22:35
 */
public class Q138 {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //老节点和新节点的对应关系
        Map<Node, Node> oldNewMap = new HashMap<>();
        //建立虚拟头节点便于处理
        Node res = new Node(0), tempNew = res, tempOld = head;
        while (tempOld != null) {
            tempNew.next = new Node(tempOld.val);
            tempNew = tempNew.next;
            //旧节点和新节点一一对应
            oldNewMap.put(tempOld, tempNew);
            tempOld = tempOld.next;
        }
        //再次便利将random关系处理好
        while (head != null) {
            if (head.random != null) {
                oldNewMap.get(head).random = oldNewMap.get(head.random);
            }
            head = head.next;
        }
        return res.next;
    }

    public Node newCopy(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node n = map.get(cur);
            n.random = map.get(cur.random);
            n.next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);
    }
}
