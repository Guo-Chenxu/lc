package lc;

import java.util.PriorityQueue;

class ListNode {
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

public class lc23 {
    // 这里是优先队列
    // 还可以分治, 每次均分, 先合并小链表组成大链表然后再合并
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.val - o2.val;
        });
        for (ListNode node : lists) {
            if (node != null){
                pq.add(node);
            }
        }
        ListNode cur = pq.poll();
        if (cur == null){
            return cur;
        }
        if (cur.next != null){
            pq.add(cur.next);
        }
        ListNode dummy = new ListNode(-1, cur);
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur != null && cur.next != null) {
                pq.add(cur.next);
            }
        }
        return dummy.next;
    }
}
