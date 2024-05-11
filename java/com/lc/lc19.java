package lc;

public class lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = n;
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
