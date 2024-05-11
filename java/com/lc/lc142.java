package lc;

public class lc142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy.next, fast = dummy.next.next;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != slow || fast == null) {
            return null;
        }
        while (dummy != slow) {
            dummy = dummy.next;
            slow = slow.next;
        }
        return dummy;
    }
}
