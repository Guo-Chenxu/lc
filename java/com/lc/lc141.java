package lc;

public class lc141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy.next, fast = dummy.next.next;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != slow || fast == null) {
            return false;
        }
        return true;
    }
}