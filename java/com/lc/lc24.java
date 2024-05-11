package lc;

public class lc24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, slow = dummy.next, fast = dummy.next.next, temp;
        while (fast != null) {
            temp = fast.next;
            pre.next = fast;
            fast.next = slow;
            slow.next = temp;
            if (temp == null) {
                break;
            }
            pre = slow;
            slow = temp;
            fast = slow.next;
        }
        return dummy.next;
    }
}
