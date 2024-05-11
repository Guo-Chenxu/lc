package lc;

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class lc138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node cur = head, pre = dummy;
        while (cur != null) {
            Node temp = new Node(cur.val);
            pre.next = temp;
            map.put(cur, temp);
            pre = temp;
            cur = cur.next;
        }
        cur = head;
        pre = dummy.next;
        while (cur != null) {
            pre.random = map.get(cur.random);
            cur = cur.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}